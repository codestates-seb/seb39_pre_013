package com.codestates.server.user.dto;

import com.codestates.server.answer.dto.AnswerDto;
import com.codestates.server.question.dto.QuestionDto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDto {
    private Long id;
    private String email;
    private String nickname;
    private Long reputation;
    private String title;
    private String aboutMe;
    private String location;
    private String websiteLink;
    private String twitterLink;
    private String githubLink;
    private String roles;
    @ToString.Exclude
    private List<QuestionDto> questions = new ArrayList<>();

//    private List<ResponseTagDto> tags = new ArrayList<>();
//
//    private List<AnswerDto> answers = new ArrayList<>();

    @Builder
    public UserDto(Long id, String email, String nickname, Long reputation, String title, String aboutMe, String location, String websiteLink, String twitterLink, String githubLink, String roles, List<QuestionDto> questions, List<ResponseTagDto> tags, List<AnswerDto> answers) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.reputation = reputation;
        this.title = title;
        this.aboutMe = aboutMe;
        this.location = location;
        this.websiteLink = websiteLink;
        this.twitterLink = twitterLink;
        this.githubLink = githubLink;
        this.roles = roles;
        this.questions = questions;
//        this.tags = tags;
//        this.answers = answers;
    }
}
