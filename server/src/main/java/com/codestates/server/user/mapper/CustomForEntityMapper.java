package com.codestates.server.user.mapper;

import com.codestates.server.answer.dto.AnswerDto;
import com.codestates.server.answer.entity.Answer;
import com.codestates.server.question.dto.QuestionDto;
import com.codestates.server.question.entity.Question;
import com.codestates.server.user.entity.UserTag;
import com.codestates.server.subscribe.dto.SubscribeDto;
import com.codestates.server.subscribe.entity.Subscribe;
import com.codestates.server.user.dto.UserTagDto;
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

    //Todo 4
    @Named("SubscribeToSubscribeDto")
    @Mappings({
            @Mapping(target = "userId", source = "user.id" ),
            @Mapping(target = "questionId", source = "question.id"),
            @Mapping(target = "questionTitle", source = "question.title"),
            @Mapping(target = "answerId", source = "answer.id"),
            @Mapping(target = "answerContent", source = "answer.content")
    })
    SubscribeDto subScribeToSubscribeDto(Subscribe subscribe);

    @IterableMapping(qualifiedByName = "SubscribeToSubscribeDto")
    List<SubscribeDto> subscribeListToSubscribeDtoList(List<Subscribe> list);




}
