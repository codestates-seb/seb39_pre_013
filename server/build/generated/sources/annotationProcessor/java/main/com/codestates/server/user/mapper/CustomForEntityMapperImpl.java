package com.codestates.server.user.mapper;

import com.codestates.server.answer.dto.AnswerDto;
import com.codestates.server.answer.entity.Answer;
import com.codestates.server.question.dto.QuestionDto;
import com.codestates.server.question.entity.Question;
import com.codestates.server.subscribe.dto.SubscribeDto;
import com.codestates.server.subscribe.entity.Subscribe;
import com.codestates.server.user.dto.UserDto;
import com.codestates.server.user.dto.UserTagDto;
import com.codestates.server.user.entity.User;
import com.codestates.server.user.entity.UserTag;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-02T23:05:59+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class CustomForEntityMapperImpl implements CustomForEntityMapper {

    @Override
    public QuestionDto questionToQuestionDto(Question question) {
        if ( question == null ) {
            return null;
        }

        Long id = null;
        String title = null;

        id = question.getId();
        title = question.getTitle();

        UserDto user = null;

        QuestionDto questionDto = new QuestionDto( id, title, user );

        return questionDto;
    }

    @Override
    public List<QuestionDto> questionsToQuestionDtos(List<Question> questions) {
        if ( questions == null ) {
            return null;
        }

        List<QuestionDto> list = new ArrayList<QuestionDto>( questions.size() );
        for ( Question question : questions ) {
            list.add( questionToQuestionDto( question ) );
        }

        return list;
    }

    @Override
    public AnswerDto answerToAnswerDto(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        AnswerDto answerDto = new AnswerDto();

        answerDto.setId( answer.getId() );
        answerDto.setContent( answer.getContent() );

        return answerDto;
    }

    @Override
    public List<AnswerDto> answersToAnswerDtos(List<Answer> answers) {
        if ( answers == null ) {
            return null;
        }

        List<AnswerDto> list = new ArrayList<AnswerDto>( answers.size() );
        for ( Answer answer : answers ) {
            list.add( answerToAnswerDto( answer ) );
        }

        return list;
    }

    @Override
    public UserTagDto userTagToUserTagDto(UserTag userTag) {
        if ( userTag == null ) {
            return null;
        }

        UserTagDto userTagDto = new UserTagDto();

        userTagDto.setId( userTag.getId() );
        userTagDto.setName( userTag.getName() );

        return userTagDto;
    }

    @Override
    public List<UserTagDto> userTagsToUserTagDtos(List<UserTag> list) {
        if ( list == null ) {
            return null;
        }

        List<UserTagDto> list1 = new ArrayList<UserTagDto>( list.size() );
        for ( UserTag userTag : list ) {
            list1.add( userTagToUserTagDto( userTag ) );
        }

        return list1;
    }

    @Override
    public SubscribeDto subScribeToSubscribeDto(Subscribe subscribe) {
        if ( subscribe == null ) {
            return null;
        }

        Long userId = null;
        Long questionId = null;
        String questionTitle = null;
        Long answerId = null;
        String answerContent = null;
        Long id = null;

        userId = subscribeUserId( subscribe );
        questionId = subscribeQuestionId( subscribe );
        questionTitle = subscribeQuestionTitle( subscribe );
        answerId = subscribeAnswerId( subscribe );
        answerContent = subscribeAnswerContent( subscribe );
        id = subscribe.getId();

        SubscribeDto subscribeDto = new SubscribeDto( id, userId, questionId, questionTitle, answerId, answerContent );

        return subscribeDto;
    }

    @Override
    public List<SubscribeDto> subscribeListToSubscribeDtoList(List<Subscribe> list) {
        if ( list == null ) {
            return null;
        }

        List<SubscribeDto> list1 = new ArrayList<SubscribeDto>( list.size() );
        for ( Subscribe subscribe : list ) {
            list1.add( subScribeToSubscribeDto( subscribe ) );
        }

        return list1;
    }

    private Long subscribeUserId(Subscribe subscribe) {
        if ( subscribe == null ) {
            return null;
        }
        User user = subscribe.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long subscribeQuestionId(Subscribe subscribe) {
        if ( subscribe == null ) {
            return null;
        }
        Question question = subscribe.getQuestion();
        if ( question == null ) {
            return null;
        }
        Long id = question.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String subscribeQuestionTitle(Subscribe subscribe) {
        if ( subscribe == null ) {
            return null;
        }
        Question question = subscribe.getQuestion();
        if ( question == null ) {
            return null;
        }
        String title = question.getTitle();
        if ( title == null ) {
            return null;
        }
        return title;
    }

    private Long subscribeAnswerId(Subscribe subscribe) {
        if ( subscribe == null ) {
            return null;
        }
        Answer answer = subscribe.getAnswer();
        if ( answer == null ) {
            return null;
        }
        Long id = answer.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String subscribeAnswerContent(Subscribe subscribe) {
        if ( subscribe == null ) {
            return null;
        }
        Answer answer = subscribe.getAnswer();
        if ( answer == null ) {
            return null;
        }
        String content = answer.getContent();
        if ( content == null ) {
            return null;
        }
        return content;
    }
}
