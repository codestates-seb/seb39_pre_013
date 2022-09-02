package com.codestates.server.user.mapper;

import com.codestates.server.answer.dto.AnswerDto;
import com.codestates.server.answer.entity.Answer;
import com.codestates.server.question.dto.QuestionDto;
import com.codestates.server.question.entity.Question;
import com.codestates.server.subscribe.dto.SubscribeDto;
import com.codestates.server.subscribe.entity.Subscribe;
import com.codestates.server.tag.dto.TagDto;
import com.codestates.server.tag.entity.Tag;
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
    date = "2022-09-02T23:11:14+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private CustomForEntityMapper customForEntityMapper;
    @Autowired
    private CustomForDtoMapper customForDtoMapper;

    @Override
    public UserTagDto tagDtoToUserTagDto(TagDto tagDto) {
        if ( tagDto == null ) {
            return null;
        }

        UserTagDto userTagDto = new UserTagDto();

        userTagDto.setName( tagDto.getName() );

        return userTagDto;
    }

    @Override
    public UserTag userTagDtoToUserTag(UserTagDto userTagDto) {
        if ( userTagDto == null ) {
            return null;
        }

        UserTag userTag = new UserTag();

        userTag.setName( userTagDto.getName() );

        return userTag;
    }

    @Override
    public UserTag tagDtoToUserTag(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        UserTag userTag = new UserTag();

        userTag.setTag( tagToTag( tag ) );
        userTag.setId( tag.getId() );
        userTag.setName( tag.getName() );

        return userTag;
    }

    @Override
    public User signUpDtoToUser(UserRequestDto.signUp dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.email( dto.getEmail() );
        user.password( dto.getPassword() );
        user.nickname( dto.getNickname() );

        return user.build();
    }

    @Override
    public User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.questions( questionDtoListToQuestionList( userDto.getQuestions() ) );
        user.userTags( userTagDtoListToUserTagList( userDto.getUserTags() ) );
        user.answers( answerDtoListToAnswerList( userDto.getAnswers() ) );
        user.id( userDto.getId() );
        user.email( userDto.getEmail() );
        user.nickname( userDto.getNickname() );
        user.reputation( userDto.getReputation() );
        user.title( userDto.getTitle() );
        user.aboutMe( userDto.getAboutMe() );
        user.location( userDto.getLocation() );
        user.websiteLink( userDto.getWebsiteLink() );
        user.twitterLink( userDto.getTwitterLink() );
        user.githubLink( userDto.getGithubLink() );
        user.roles( userDto.getRoles() );

        return user.build();
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

    protected Tag tagToTag(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        Tag tag1 = new Tag();

        tag1.setId( tag.getId() );

        return tag1;
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
