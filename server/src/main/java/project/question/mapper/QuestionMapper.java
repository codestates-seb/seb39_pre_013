package project.question.mapper;

import org.mapstruct.Mapper;
import project.question.dto.QuestionPatchDto;
import project.question.dto.QuestionPostDto;
import project.question.dto.QuestionResponseDto;
import project.question.entity.Question;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    Question questionPostDtoToQuestion(QuestionPostDto questionPostDto);

    Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto);

    QuestionResponseDto questionToQuestionResponseDto(Question question);

    List<QuestionResponseDto> questionsToQuestionResponseDtos(List<Question> questions);
}
