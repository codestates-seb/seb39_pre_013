package com.codestates.server.user.entity;

import com.codestates.server.tag.entity.Tag;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
public class UserTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TAG_ID")
    private Tag tag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

//    public void setUser(User user){
//        this.user = user;
//        if (!this.user.getUserTags().contains(this)) {
//            this.user.getUserTags().add(this);
//        }
//    }
}
