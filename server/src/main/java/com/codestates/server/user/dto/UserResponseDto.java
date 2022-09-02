package com.codestates.server.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String email;
    private String nickname;
    private Long reputation;
//    private List<Question> questions;
}
