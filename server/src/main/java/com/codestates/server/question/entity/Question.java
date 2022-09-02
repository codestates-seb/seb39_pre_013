package com.codestates.server.question.entity;

import com.codestates.server.subscribe.entity.Subscribe;
import com.codestates.server.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.util.List;

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

    @OneToMany(mappedBy = "question")
    private List<Subscribe> subscribes;

    public void setUser(User user){
        this.user = user;
        if (!this.user.getQuestions().contains(this)){
            this.user.getQuestions().add(this);

        }
    }
}
