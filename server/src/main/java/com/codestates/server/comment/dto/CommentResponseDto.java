package com.codestates.server.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import com.codestates.server.user.dto.UserResponseDto;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Data
public class CommentResponseDto {
    private long id;
    private String content;
    private UserResponseDto user;
    private LocalDateTime modifiedAt;
}
