package com.codestates.server.answer.mapper;

import com.codestates.server.answer.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.codestates.server.answer.dto.AnswerPatchDto;
import com.codestates.server.answer.dto.AnswerPostDto;
import com.codestates.server.answer.dto.AnswerResponseDto;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    @Mapping(source = "questionId", target = "question.id")
    @Mapping(source = "userId", target = "user.id")
    Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto);

    Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto);

//    @Mapping(target = "", ignore = true)
    AnswerResponseDto answerToAnswerResponseDto(Answer answer);
}
