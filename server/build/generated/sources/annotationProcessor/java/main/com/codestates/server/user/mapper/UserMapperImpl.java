package com.codestates.server.user.mapper;

import com.codestates.server.answer.dto.AnswerDto;
import com.codestates.server.answer.entity.Answer;
import com.codestates.server.question.dto.QuestionDto;
import com.codestates.server.question.entity.Question;
import com.codestates.server.subscribe.dto.SubscribeDto;
import com.codestates.server.subscribe.entity.Subscribe;
import com.codestates.server.user.dto.UserDto;
import com.codestates.server.user.dto.UserRequestDto;
import com.codestates.server.user.dto.UserTagDto;
import com.codestates.server.user.entity.User;
import com.codestates.server.user.entity.UserTag;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-01T20:56:15+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private CustomForEntityMapper customForEntityMapper;
    @Autowired
    private CustomForDtoMapper customForDtoMapper;

    @Override
    public User signUpDtoToUser(UserRequestDto.signUp dto) {
        if ( dto == null ) {
            return null;
        }

        List<UserTag> userTags = null;
        String email = null;
        String password = null;
        String nickname = null;

        userTags = userTagDtoListToUserTagList( dto.getUserTags() );
        email = dto.getEmail();
        password = dto.getPassword();
        nickname = dto.getNickname();

        Long id = null;
        Long reputation = null;
        String title = null;
        String aboutMe = null;
        String location = null;
        String websiteLink = null;
        String twitterLink = null;
        String githubLink = null;
        String roles = null;
        List<Question> questions = null;
        List<Answer> answers = null;
        List<Subscribe> subscribes = null;

        User user = new User( id, email, password, nickname, reputation, title, aboutMe, location, websiteLink, twitterLink, githubLink, roles, questions, userTags, answers, subscribes );

        return user;
    }

    @Override
    public User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        List<Question> questions = null;
        List<UserTag> userTags = null;
        List<Answer> answers = null;
        Long id = null;
        String email = null;
        String nickname = null;
        Long reputation = null;
        String title = null;
        String aboutMe = null;
        String location = null;
        String websiteLink = null;
        String twitterLink = null;
        String githubLink = null;
        String roles = null;

        questions = questionDtoListToQuestionList( userDto.getQuestions() );
        userTags = userTagDtoListToUserTagList( userDto.getUserTags() );
        answers = answerDtoListToAnswerList( userDto.getAnswers() );
        id = userDto.getId();
        email = userDto.getEmail();
        nickname = userDto.getNickname();
        reputation = userDto.getReputation();
        title = userDto.getTitle();
        aboutMe = userDto.getAboutMe();
        location = userDto.getLocation();
        websiteLink = userDto.getWebsiteLink();
        twitterLink = userDto.getTwitterLink();
        githubLink = userDto.getGithubLink();
        roles = userDto.getRoles();

        List<Subscribe> subscribes = null;
        String password = null;

        User user = new User( id, email, password, nickname, reputation, title, aboutMe, location, websiteLink, twitterLink, githubLink, roles, questions, userTags, answers, subscribes );

        return user;
    }

    @Override
    public List<User> userDtoListToUserList(List<UserDto> users) {
        if ( users == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( users.size() );
        for ( UserDto userDto : users ) {
            list.add( userDtoToUser( userDto ) );
        }

        return list;
    }

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.subscribes( subscribeListToSubscribeDtoList1( user.getSubscribes() ) );
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
        userDto.questions( customForEntityMapper.questionsToQuestionDtos( user.getQuestions() ) );
        userDto.userTags( customForEntityMapper.userTagsToUserTagDtos( user.getUserTags() ) );
        userDto.answers( customForEntityMapper.answersToAnswerDtos( user.getAnswers() ) );

        return userDto.build();
    }

    @Override
    public List<UserDto> userListToUserDtoList(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( users.size() );
        for ( User user : users ) {
            list.add( userToUserDto( user ) );
        }

        return list;
    }

    protected List<UserTag> userTagDtoListToUserTagList(List<UserTagDto> list) {
        if ( list == null ) {
            return null;
        }

        List<UserTag> list1 = new ArrayList<UserTag>( list.size() );
        for ( UserTagDto userTagDto : list ) {
            list1.add( customForDtoMapper.userTagDtoToUserTag( userTagDto ) );
        }

        return list1;
    }

    protected List<Question> questionDtoListToQuestionList(List<QuestionDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Question> list1 = new ArrayList<Question>( list.size() );
        for ( QuestionDto questionDto : list ) {
            list1.add( customForDtoMapper.questionDtoToQuestion( questionDto ) );
        }

        return list1;
    }

    protected List<Answer> answerDtoListToAnswerList(List<AnswerDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Answer> list1 = new ArrayList<Answer>( list.size() );
        for ( AnswerDto answerDto : list ) {
            list1.add( customForDtoMapper.answerDtoToAnswer( answerDto ) );
        }

        return list1;
    }

    protected List<SubscribeDto> subscribeListToSubscribeDtoList1(List<Subscribe> list) {
        if ( list == null ) {
            return null;
        }

        List<SubscribeDto> list1 = new ArrayList<SubscribeDto>( list.size() );
        for ( Subscribe subscribe : list ) {
            list1.add( customForEntityMapper.subScribeToSubscribeDto( subscribe ) );
        }

        return list1;
    }
}
