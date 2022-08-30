package project.answer.mapper;

import org.mapstruct.Mapper;
import project.answer.dto.AnswerPatchDto;
import project.answer.dto.AnswerPostDto;
import project.answer.dto.AnswerResponseDto;
import project.answer.entity.Answer;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto);

    Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto);

    AnswerResponseDto answerToAnswerResponseDto(Answer answer);
}
