package com.codestates.server.user.mapper;

import com.codestates.server.tag.entity.Tag;
import com.codestates.server.user.dto.UserDto;
import com.codestates.server.user.dto.UserRequestDto;
import com.codestates.server.user.entity.User;
import com.codestates.server.user.entity.UserTag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CustomForEntityMapper.class, CustomForDtoMapper.class})
public interface UserMapper {


    //Todo
//    @Mapping(target = "userTags", source = "userTags", qualifiedByName = "UserTagDtoToUserTag")
    //tagDto -> userTag바껴야한다

    @Mapping(target="tag.id" , source = "id")
    UserTag tagDtoToUserTag(Tag tag);

    @Mapping(target = "email", source = "email")
    User signUpDtoToUser(UserRequestDto.signUp dto);

    @Mappings({
            @Mapping(target = "questions", source = "questions", qualifiedByName = "QuestionDtoToQuestion"),
            @Mapping(target = "userTags", source = "userTags", qualifiedByName = "UserTagDtoToUserTag"),
            @Mapping(target = "answers", source = "answers", qualifiedByName = "AnswerDtoToAnswer"),
            @Mapping(target = "subscribes", ignore = true)
    })
    User userDtoToUser(UserDto userDto);


    List<User> userDtoListToUserList(List<UserDto> users);

    @Mapping(target = "subscribes", source = "subscribes", qualifiedByName = "SubscribeToSubscribeDto")
    UserDto userToUserDto(User user);
    List<UserDto> userListToUserDtoList(List<User> users);
}
