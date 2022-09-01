package project.answer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.answer.dto.AnswerPatchDto;
import project.answer.dto.AnswerPostDto;
import project.answer.dto.AnswerResponseDto;
import project.answer.entity.Answer;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    @Mapping(source = "questionId", target = "question.id")
    @Mapping(source = "userId", target = "user.id")
    Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto);

    Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto);

//    @Mapping(target = "", ignore = true)
    AnswerResponseDto answerToAnswerResponseDto(Answer answer);
}
