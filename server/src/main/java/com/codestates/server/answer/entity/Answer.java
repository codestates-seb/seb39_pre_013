package com.codestates.server.answer.entity;

import com.codestates.server.subscribe.entity.Subscribe;
import com.codestates.server.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    @ToString.Exclude
    private User user;

    @OneToMany(mappedBy = "answer")
    private List<Subscribe> subscribes;

    public void setUser(User user){
        this.user = user;
        if (!this.user.getAnswers().contains(this)){
            this.user.getAnswers().add(this);
        }
    }
}
