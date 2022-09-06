package com.codestates.server.answer.entity;

import com.codestates.server.comment.entity.Comment;
import com.codestates.server.common.listener.BaseEntity;
import com.codestates.server.question.entity.Question;
import com.codestates.server.subscribe.entity.Subscribe;
import com.codestates.server.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Answer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    @ToString.Exclude
    private User user;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
//    @JsonManagedReference
//    @JsonBackReference
    private Question question;

    @OneToMany(mappedBy = "answer")
    private List<Subscribe> subscribes = new ArrayList<>();


    @OneToMany(mappedBy = "answer")
    private List<Comment> comments = new ArrayList<>();

    private Integer recommendation;

    public void setUser(User user){
        this.user = user;
        if (!this.user.getAnswers().contains(this)){
            this.user.getAnswers().add(this);
        }
    }

    public void setQuestion(Question question) {
        this.question = question;
        if (!this.question.getAnswers().contains(this)) {
            this.question.getAnswers().add(this);
        }
    }
}
