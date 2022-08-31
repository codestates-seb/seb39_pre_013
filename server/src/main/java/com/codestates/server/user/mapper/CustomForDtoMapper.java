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
public interface CustomForDtoMapper {

    //Todo 1
    @Named("QuestionDtoToQuestion")
    @Mapping(target = "user", ignore = true)
    Question questionDtoToQuestion( QuestionDto question);
    @IterableMapping(qualifiedByName = "QuestionDtoToQuestion")
    List<Question> questionDtosToQuestions(List<QuestionDto> questions);

    //Todo 2
    @Named("AnswerDtoToAnswer")
    @Mapping(target = "user", ignore = true)
    Answer answerDtoToAnswer(AnswerDto answer);
    @IterableMapping(qualifiedByName = "AnswerDtoToAnswer")
    List<Answer> answerDtosToAnswers(List<AnswerDto> answers);

    //Todo 3
    @Named("UserTagDtoToUserTag")
    @Mappings({
            @Mapping(target = "tag", ignore = true),
            @Mapping(target = "user", ignore = true)
    })
    UserTag userTagDtoToUserTag(UserTagDto userTag);

    @IterableMapping(qualifiedByName = "UserTagDtoToUserTag")
    List<UserTag> userTagDtosToUserTags(List<UserTagDto> list);
}
