package com.codestates.server.question.entity;

import com.codestates.server.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.lang.reflect.Member;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne()
    @JoinColumn(name = "USER_ID")
    @ToString.Exclude
    private User user;

    public void setUser(User user){
        this.user = user;
        if (!this.user.getQuestions().contains(this)){
            this.user.getQuestions().add(this);

        }
    }
}
