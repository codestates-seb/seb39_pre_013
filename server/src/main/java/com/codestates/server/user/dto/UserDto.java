package com.codestates.server.user.dto;

import com.codestates.server.answer.dto.AnswerDto;
import com.codestates.server.question.dto.QuestionDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
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
    private List<QuestionDto> questions = new ArrayList<>();

    private List<UserTagDto> tags = new ArrayList<>();

    private List<AnswerDto> answers = new ArrayList<>();

    @Builder
    public UserDto(Long id, String email, String nickname) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
    }
}
