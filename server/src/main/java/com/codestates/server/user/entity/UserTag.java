package com.codestates.server.user.entity;

import com.codestates.server.tag.entity.Tag;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TAG_ID")
    private Tag tag;



    public void setUser(User user){
        this.user = user;
        if (!this.user.getUserTags().contains(this)) {
            this.user.getUserTags().add(this);
        }
    }

    public void setTag(Tag tag){
        this.tag = tag;
        if (this.tag.getUserTags().contains(this)) {
            this.tag.getUserTags().add(this);
        }
    }
}
