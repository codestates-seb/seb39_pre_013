package com.codestates.server.question.entity;

import com.codestates.server.answer.entity.Answer;
import com.codestates.server.comment.entity.Comment;
import com.codestates.server.common.listener.BaseEntity;
import com.codestates.server.subscribe.entity.Subscribe;
import com.codestates.server.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Question extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne()
    @JoinColumn(name = "USER_ID")
    @ToString.Exclude
    private User user;

    @Column(nullable = false)
    private String content;

    private Integer view;

    private Integer vote;

    @OneToMany(mappedBy = "question")
    private List<Subscribe> subscribes = new ArrayList<>();

    @OneToMany(mappedBy = "question")
    private List<QuestionTag> questionTags = new ArrayList<>();

    @OneToMany(mappedBy = "question")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();



    public void addUser(User user){
        this.user = user;
        if (!this.user.getQuestions().contains(this)){
            this.user.getQuestions().add(this);

        }
    }
}
