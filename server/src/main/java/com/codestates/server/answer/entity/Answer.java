package com.codestates.server.answer.entity;

import com.codestates.server.user.entity.User;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

//    public void setUser(User user){
//        this.user = user;
//        if (!this.user.getAnswers().contains(this)){
//            this.user.getAnswers().add(this);
//        }
//    }
}
