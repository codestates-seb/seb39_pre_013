package com.codestates.server.question.dto;

import com.codestates.server.user.dto.UserDto;
import com.codestates.server.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
public class QuestionDto {
    private Long id;
    private String title;

    private UserDto user;
}
