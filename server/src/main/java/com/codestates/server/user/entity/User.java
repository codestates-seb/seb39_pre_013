package com.codestates.server.user.entity;

import com.codestates.server.common.listener.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@ToString
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private Long reputation;
    private String title;
    private String aboutMe;
    private String location;
    private String websiteLink;
    private String twitterLink;
    private String githubLink;
    private String roles;
    private ArrayList<UserTag> tags = new ArrayList<>();


    @Builder
    public User(Long id, String email, String password, String nickname, Long reputation, String title, String aboutMe, String location, String websiteLink, String twitterLink, String githubLink, String roles,ArrayList<UserTag> tags) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.reputation = reputation;
        this.title = title;
        this.aboutMe = aboutMe;
        this.location = location;
        this.websiteLink = websiteLink;
        this.twitterLink = twitterLink;
        this.githubLink = githubLink;
        this.roles = roles;
        this.tags = tags;

    }

    public List<String> getRoleList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

}
