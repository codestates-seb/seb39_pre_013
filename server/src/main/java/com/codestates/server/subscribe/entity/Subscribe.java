package com.codestates.server.subscribe.entity;


import com.codestates.server.answer.entity.Answer;
import com.codestates.server.question.entity.Question;
import com.codestates.server.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTION_ID",nullable = true)
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ANSWER_ID",nullable = true)
    private Answer answer;

    public void setQuestion(Question question) {
        this.question = question;
        if (!this.question.getSubscribes().contains(this)){
            this.question.getSubscribes().add(this);
        }
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
        if (!this.answer.getSubscribes().contains(this)){
            this.answer.getSubscribes().add(this);
        }
    }

    public void setUser(User user) {
        this.user = user;
        if (!this.user.getSubscribes().contains(this)){
            this.user.getSubscribes().add(this);
        }
    }
}
