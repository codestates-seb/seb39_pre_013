package com.codestates.server.question.mapper;

import com.codestates.server.answer.entity.Answer;
import com.codestates.server.question.entity.Question;
import com.codestates.server.user.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.codestates.server.answer.dto.AnswerResponseDto;
import com.codestates.server.comment.dto.CommentResponseDto;
import com.codestates.server.comment.entity.Comment;
import com.codestates.server.question.dto.QuestionPatchDto;
import com.codestates.server.question.dto.QuestionPostDto;
import com.codestates.server.question.dto.QuestionResponseDto;
import com.codestates.server.question.dto.QuestionTagResponseDto;
import com.codestates.server.question.entity.QuestionTag;
import com.codestates.server.user.dto.UserResponseDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    @Mapping(source = "userId", target = "user.id")
    Question questionPostDtoToQuestion(QuestionPostDto questionPostDto);

    Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto);

    QuestionResponseDto questionToQuestionResponseDto(Question question);

    List<QuestionResponseDto> questionsToQuestionResponseDtos(List<Question> questions);

    @InheritInverseConfiguration
    UserResponseDto userToUserResponseDto(User user);
    @InheritInverseConfiguration
    List<AnswerResponseDto> answersToAnswerResponseDtos(List<Answer> answers);

    @InheritInverseConfiguration
    List<CommentResponseDto> commentToCommentResponseDtos(List<Comment> comments);

    @InheritInverseConfiguration
    List<QuestionTagResponseDto> questionTagsToQuestionTagResponseDtos(List<QuestionTag> questionTags);
}
