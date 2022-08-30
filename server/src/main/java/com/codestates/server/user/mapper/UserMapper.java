package com.codestates.server.user.mapper;

import com.codestates.server.question.mapper.QuestionMapper;
import com.codestates.server.user.dto.ResponseTagDto;
import com.codestates.server.user.dto.UserDto;
import com.codestates.server.user.dto.UserRequestDto;
import com.codestates.server.tag.entity.Tag;
import com.codestates.server.user.dto.UserTagDto;
import com.codestates.server.user.entity.User;
import com.codestates.server.user.entity.UserTag;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",uses = {QuestionMapper.class})
public interface UserMapper {
    User signUpDtoToUserEntity(UserRequestDto.signUp dto);
    //ResponseTagDto - > UserTag로 바꾸고 ->  Tag로 바꾼다.
    UserTag tagToDto(ResponseTagDto tag);
    Tag userTagToTag(UserTag userTag);
    ResponseTagDto userTagDtoToTagDto(UserTagDto userTagDto);

    UserDto userEntityToUserDto(User user);

    List<UserDto> userListToUserDtoList(List<User> users);
}
