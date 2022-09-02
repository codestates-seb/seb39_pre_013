package com.codestates.server.subscribe.dto;

import com.codestates.server.answer.dto.AnswerDto;
import com.codestates.server.question.dto.QuestionDto;
import com.codestates.server.question.entity.Question;
import com.codestates.server.user.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

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
