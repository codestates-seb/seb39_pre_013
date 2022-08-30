package com.codestates.server.question.mapper;

import com.codestates.server.question.dto.QuestionDto;
import com.codestates.server.question.entity.Question;

import java.util.List;

public interface QuestionMapper {
    QuestionDto questionToQuestionDto(Question question);
    List<QuestionDto> questionListToQuestionDtos(List<Question> questions);
}
