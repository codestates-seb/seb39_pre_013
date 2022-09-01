package com.codestates.server.subscribe.dto;

import com.codestates.server.answer.dto.AnswerDto;
import com.codestates.server.question.dto.QuestionDto;
import com.codestates.server.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@Getter
@AllArgsConstructor
public class SubscribeDto {
    private Long id;
    private Long userId;
    private Long questionId;
    private Long answerId;
}
