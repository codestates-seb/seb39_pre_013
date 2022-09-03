package com.codestates.server.user.mapper;

import com.codestates.server.answer.dto.AnswerDto;
import com.codestates.server.answer.entity.Answer;
import com.codestates.server.question.dto.QuestionDto;
import com.codestates.server.question.entity.Question;
import com.codestates.server.user.dto.UserTagDto;
import com.codestates.server.user.entity.UserTag;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-03T13:05:12+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class CustomForDtoMapperImpl implements CustomForDtoMapper {

    @Override
    public Question questionDtoToQuestion(QuestionDto question) {
        if ( question == null ) {
            return null;
        }

        Question question1 = new Question();

        question1.setId( question.getId() );
        question1.setTitle( question.getTitle() );

        return question1;
    }

    @Override
    public List<Question> questionDtosToQuestions(List<QuestionDto> questions) {
        if ( questions == null ) {
            return null;
        }

        List<Question> list = new ArrayList<Question>( questions.size() );
        for ( QuestionDto questionDto : questions ) {
            list.add( questionDtoToQuestion( questionDto ) );
        }

        return list;
    }

    @Override
    public Answer answerDtoToAnswer(AnswerDto answer) {
        if ( answer == null ) {
            return null;
        }

        Answer answer1 = new Answer();

        answer1.setId( answer.getId() );
        answer1.setContent( answer.getContent() );

        return answer1;
    }

    @Override
    public List<Answer> answerDtosToAnswers(List<AnswerDto> answers) {
        if ( answers == null ) {
            return null;
        }

        List<Answer> list = new ArrayList<Answer>( answers.size() );
        for ( AnswerDto answerDto : answers ) {
            list.add( answerDtoToAnswer( answerDto ) );
        }

        return list;
    }

    @Override
    public UserTag userTagDtoToUserTag(UserTagDto userTag) {
        if ( userTag == null ) {
            return null;
        }

        UserTag userTag1 = new UserTag();

        userTag1.setId( userTag.getId() );
        userTag1.setName( userTag.getName() );

        return userTag1;
    }

    @Override
    public List<UserTag> userTagDtosToUserTags(List<UserTagDto> list) {
        if ( list == null ) {
            return null;
        }

        List<UserTag> list1 = new ArrayList<UserTag>( list.size() );
        for ( UserTagDto userTagDto : list ) {
            list1.add( userTagDtoToUserTag( userTagDto ) );
        }

        return list1;
    }
}
