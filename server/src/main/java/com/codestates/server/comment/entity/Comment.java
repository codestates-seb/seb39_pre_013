package com.codestates.server.comment.entity;

import com.codestates.server.answer.entity.Answer;
import com.codestates.server.common.listener.BaseEntity;
import com.codestates.server.question.entity.Question;
import com.codestates.server.user.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Data
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    public void addQuestion(Question question) {
        this.question = question;
        if (!this.question.getComments().contains(this)) {
            this.question.getComments().add(this);
        }
    }

    @ManyToOne
    @JoinColumn(name = "ANSWER_ID")
    private Answer answer;

//    public void addAnswer(Answer answer) {
//        this.answer = answer;
//        if (!this.answer.getComments().contains(this)) {
//            this.answer.getComments().add(this);
//        }
//    }
}
