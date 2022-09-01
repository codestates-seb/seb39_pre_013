package project.question.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.answer.dto.AnswerResponseDto;
import project.answer.entity.Answer;
import project.question.dto.QuestionPatchDto;
import project.question.dto.QuestionPostDto;
import project.question.dto.QuestionResponseDto;
import project.question.entity.Question;
import project.user.dto.UserResponseDto;
import project.user.entity.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    @Mapping(source = "userId", target = "user.id")
    Question questionPostDtoToQuestion(QuestionPostDto questionPostDto);

    Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto);

//    @Mapping(target = "user.answers", ignore = true)
//    @Mapping(target = "user.questions", ignore = true)
//    @Mapping(target = "user.userTags", ignore = true)
////    @Mapping(target = "answers[].question", ignore = true)
//    @Mapping(target = "answers", ignore = true)
//    @Mapping(target = "questionTags", ignore = true)
//    @Mapping(target = "comments", ignore = true)
//    @InheritInverseConfiguration(name = "answersToAnswerResponseDtos")
//    @InheritInverseConfiguration(name = "userToUserResponseDto")
//    @Mapping(source = "user", target = ".")
//    @Mapping(source = "answers", target = ".")
    QuestionResponseDto questionToQuestionResponseDto(Question question);

    List<QuestionResponseDto> questionsToQuestionResponseDtos(List<Question> questions);

    @InheritInverseConfiguration
    UserResponseDto userToUserResponseDto(User user);
//
    @InheritInverseConfiguration
    List<AnswerResponseDto> answersToAnswerResponseDtos(List<Answer> answers);
}
