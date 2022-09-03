package com.codestates.server.user.entity;

import com.codestates.server.answer.entity.Answer;
import com.codestates.server.common.listener.BaseEntity;
import com.codestates.server.question.entity.Question;
import com.codestates.server.subscribe.entity.Subscribe;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@ToString
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, updatable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    private String nickname;
    private Long reputation;
    private String title;
    private String aboutMe;
    private String location;
    private String websiteLink;
    private String twitterLink;
    private String githubLink;
    private String roles;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<UserTag> userTags = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Answer> answers = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Subscribe> subscribes = new ArrayList<>();

    public void addQuestion(Question question){
        questions.add(question);
        if (question.getUser() != this){
            question.addUser(this);
        }
    }

    public void addUserTag(UserTag userTag){
        userTags.add(userTag);
        if (userTag.getUser() != this){
            userTag.setUser(this);
        }
    }
    public void addAnswer(Answer answer){
        answers.add(answer);
        if (answer.getUser()!=this){
            answer.setUser(this);
        }
    }
    @Builder
    public User(Long id, String email, String password, String nickname, Long reputation, String title, String aboutMe, String location, String websiteLink, String twitterLink, String githubLink, String roles, List<Question> questions, List<UserTag> userTags, List<Answer> answers, List<Subscribe> subscribes) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.reputation = reputation;
        this.title = title;
        this.aboutMe = aboutMe;
        this.location = location;
        this.websiteLink = websiteLink;
        this.twitterLink = twitterLink;
        this.githubLink = githubLink;
        this.roles = roles;
        this.questions = questions==null? new ArrayList<>():questions;
        this.userTags = userTags==null? new ArrayList<>():userTags;
        this.answers = answers==null? new ArrayList<>():answers;
        this.subscribes = subscribes;
    }

    public List<String> getRoleList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

}
