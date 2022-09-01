package project.user.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import project.answer.entity.Answer;
import project.question.entity.Question;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USERS")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, updatable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String nickname;
    private Long reputation;
    private String title;
    private String aboutMe;
    private String location;
    private String websiteLink;
    private String twitterLink;
    private String githubLink;
    private String role;

    @OneToMany(mappedBy = "user",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
//    @JsonBackReference
//    @JsonManagedReference
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<UserTag> userTags = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
//    @JsonBackReference
//    @JsonManagedReference
    private List<Answer> answers = new ArrayList<>();

    public void addQuestion(Question question){
        questions.add(question);
        if (question.getUser() != this){
            question.setUser(this);
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
//    @Builder
//    public User(Long id, String email, String password, String nickname, Long reputation, String title, String aboutMe, String location, String websiteLink, String twitterLink, String githubLink, String role, ArrayList<Question> questions, ArrayList<UserTag> userTags, ArrayList<Answer> answers) {
//        this.id = id;
//        this.email = email;
//        this.password = password;
//        this.nickname = nickname;
//        this.reputation = reputation;
//        this.title = title;
//        this.aboutMe = aboutMe;
//        this.location = location;
//        this.websiteLink = websiteLink;
//        this.twitterLink = twitterLink;
//        this.githubLink = githubLink;
//        this.role = role;
//        this.questions = questions;
//        this.userTags = userTags;
//        this.answers = answers;
//    }
//
//    public List<String> getRoleList() {
//        if (this.role.length() > 0) {
//            return Arrays.asList(this.role.split(","));
//        }
//        return new ArrayList<>();
//    }
}
