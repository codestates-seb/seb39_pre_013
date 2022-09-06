package com.codestates.server.answer.dto;

import com.codestates.server.user.dto.UserDto;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDto {
    private Long id;
    private String content;
    private UserDto user;
}
