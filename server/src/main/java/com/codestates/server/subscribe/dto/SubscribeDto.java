package com.codestates.server.subscribe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SubscribeDto {
    private Long id;
    private Long userId;
    private Long questionId;
    private String questionTitle;
    private Long answerId;
    private String answerContent;
}
