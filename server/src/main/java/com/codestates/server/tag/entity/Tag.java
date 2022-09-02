package com.codestates.server.tag.entity;

import com.codestates.server.user.entity.User;
import com.codestates.server.user.entity.UserTag;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "tag")
    private List<UserTag> userTags;

    public void addUserTag(UserTag userTag){
        userTags.add(userTag);
        if (userTag.getTag()!=this){
            userTag.setTag(this);
        }
    }
}