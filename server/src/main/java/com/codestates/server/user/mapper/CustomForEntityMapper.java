package com.codestates.server.user.mapper;

import com.codestates.server.answer.dto.AnswerDto;
import com.codestates.server.answer.entity.Answer;
import com.codestates.server.question.dto.QuestionDto;
import com.codestates.server.question.entity.Question;
import com.codestates.server.user.dto.UserTagDto;
import com.codestates.server.user.entity.UserTag;
import org.mapstruct.*;

import java.util.List;
@Mapper(componentModel = "spring")
public interface CustomForEntityMapper {

    //Todo 1
    @Named("QuestionToQuestionDto")
    @Mapping(target = "user", ignore = true)
    QuestionDto questionToQuestionDto(Question question);
    @IterableMapping(qualifiedByName = "QuestionToQuestionDto")
    List<QuestionDto> questionsToQuestionDtos(List<Question> questions);

    //Todo 2
    @Named("AnswerToAnswerDto")
    @Mapping(target = "user", ignore = true)
    AnswerDto answerToAnswerDto(Answer answer);
    @IterableMapping(qualifiedByName = "AnswerToAnswerDto")
    List<AnswerDto> answersToAnswerDtos(List<Answer> answers);

    //Todo 3
    @Named("UserTagToUserTagDto")
    @Mappings({
            @Mapping(target = "tag", ignore = true),
            @Mapping(target = "user", ignore = true)
    })
    UserTagDto userTagToUserTagDto(UserTag userTag);

    @IterableMapping(qualifiedByName = "UserTagToUserTagDto")
    List<UserTagDto> userTagsToUserTagDtos(List<UserTag> list);






}
