package com.codestates.server.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserPatchDto {
    private Long id;
    private String nickname;
    private String title;
    private String location;
    private String aboutMe;
    private String githubLink;
    private String twitterLink;
    private String websiteLink;
}
