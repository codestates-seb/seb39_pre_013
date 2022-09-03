package com.codestates.server.tag.entity;

import com.codestates.server.user.entity.UserTag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(unique = true)
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
