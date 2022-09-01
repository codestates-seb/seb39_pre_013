package com.codestates.server.question.dto;

import com.codestates.server.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuestionDto {
    private Long id;
    private String title;
    private UserDto user;
}
