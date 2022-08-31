package com.codestates.server.answer.dto;

import com.codestates.server.user.dto.UserDto;
import com.codestates.server.user.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDto {
    private Long id;
    private String content;
    private UserDto user;
}
