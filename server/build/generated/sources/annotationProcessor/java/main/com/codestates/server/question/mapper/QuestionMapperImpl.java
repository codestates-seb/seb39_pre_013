package com.codestates.server.question.mapper;

import com.codestates.server.answer.dto.AnswerDto;
import com.codestates.server.answer.entity.Answer;
import com.codestates.server.question.dto.QuestionDto;
import com.codestates.server.question.entity.Question;
import com.codestates.server.subscribe.dto.SubscribeDto;
import com.codestates.server.subscribe.entity.Subscribe;
import com.codestates.server.tag.dto.TagDto;
import com.codestates.server.tag.entity.Tag;
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
    date = "2022-09-01T20:56:16+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public QuestionDto questionToQuestionDto(Question question) {
        if ( question == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        UserDto user = null;

        id = question.getId();
        title = question.getTitle();
        user = userToUserDto( question.getUser() );

        QuestionDto questionDto = new QuestionDto( id, title, user );

        return questionDto;
    }

    @Override
    public List<QuestionDto> questionListToQuestionDtos(List<Question> questions) {
        if ( questions == null ) {
            return null;
        }

        List<QuestionDto> list = new ArrayList<QuestionDto>( questions.size() );
        for ( Question question : questions ) {
            list.add( questionToQuestionDto( question ) );
        }

        return list;
    }

    protected List<UserTagDto> userTagListToUserTagDtoList(List<UserTag> list) {
        if ( list == null ) {
            return null;
        }

        List<UserTagDto> list1 = new ArrayList<UserTagDto>( list.size() );
        for ( UserTag userTag : list ) {
            list1.add( userTagToUserTagDto( userTag ) );
        }

        return list1;
    }

    protected TagDto tagToTagDto(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        TagDto tagDto = new TagDto();

        tagDto.setId( tag.getId() );
        tagDto.setName( tag.getName() );
        tagDto.setDescription( tag.getDescription() );
        tagDto.setUserTags( userTagListToUserTagDtoList( tag.getUserTags() ) );

        return tagDto;
    }

    protected UserTagDto userTagToUserTagDto(UserTag userTag) {
        if ( userTag == null ) {
            return null;
        }

        UserTagDto userTagDto = new UserTagDto();

        userTagDto.setId( userTag.getId() );
        userTagDto.setName( userTag.getName() );
        userTagDto.setUser( userToUserDto( userTag.getUser() ) );
        userTagDto.setTag( tagToTagDto( userTag.getTag() ) );

        return userTagDto;
    }

    protected AnswerDto answerToAnswerDto(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        AnswerDto answerDto = new AnswerDto();

        answerDto.setId( answer.getId() );
        answerDto.setContent( answer.getContent() );
        answerDto.setUser( userToUserDto( answer.getUser() ) );

        return answerDto;
    }

    protected List<AnswerDto> answerListToAnswerDtoList(List<Answer> list) {
        if ( list == null ) {
            return null;
        }

        List<AnswerDto> list1 = new ArrayList<AnswerDto>( list.size() );
        for ( Answer answer : list ) {
            list1.add( answerToAnswerDto( answer ) );
        }

        return list1;
    }

    protected SubscribeDto subscribeToSubscribeDto(Subscribe subscribe) {
        if ( subscribe == null ) {
            return null;
        }

        Long id = null;

        id = subscribe.getId();

        Long userId = null;
        Long questionId = null;
        String questionTitle = null;
        Long answerId = null;
        String answerContent = null;

        SubscribeDto subscribeDto = new SubscribeDto( id, userId, questionId, questionTitle, answerId, answerContent );

        return subscribeDto;
    }

    protected List<SubscribeDto> subscribeListToSubscribeDtoList(List<Subscribe> list) {
        if ( list == null ) {
            return null;
        }

        List<SubscribeDto> list1 = new ArrayList<SubscribeDto>( list.size() );
        for ( Subscribe subscribe : list ) {
            list1.add( subscribeToSubscribeDto( subscribe ) );
        }

        return list1;
    }

    protected UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.id( user.getId() );
        userDto.email( user.getEmail() );
        userDto.nickname( user.getNickname() );
        userDto.reputation( user.getReputation() );
        userDto.title( user.getTitle() );
        userDto.aboutMe( user.getAboutMe() );
        userDto.location( user.getLocation() );
        userDto.websiteLink( user.getWebsiteLink() );
        userDto.twitterLink( user.getTwitterLink() );
        userDto.githubLink( user.getGithubLink() );
        userDto.roles( user.getRoles() );
        userDto.createdAt( user.getCreatedAt() );
        userDto.modifiedAt( user.getModifiedAt() );
        userDto.questions( questionListToQuestionDtos( user.getQuestions() ) );
        userDto.userTags( userTagListToUserTagDtoList( user.getUserTags() ) );
        userDto.answers( answerListToAnswerDtoList( user.getAnswers() ) );
        userDto.subscribes( subscribeListToSubscribeDtoList( user.getSubscribes() ) );

        return userDto.build();
    }
}
