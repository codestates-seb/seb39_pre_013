package com.codestates.server.user.mapper;

import com.codestates.server.user.dto.TagDto;
import com.codestates.server.user.dto.UserDto;
import com.codestates.server.user.dto.UserRequestDto;
import com.codestates.server.tag.entity.Tag;
import com.codestates.server.user.entity.User;
import com.codestates.server.user.entity.UserTag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User signUpDtoToUserEntity(UserRequestDto.signUp dto);
    //우선 TagDto - > UserTag로 바꾸고 ->  Tag로 바꾼다.
    UserTag tagToDto(TagDto tag);
    Tag userTagToTag(UserTag userTag);

    UserDto userEntityToUserDto(User user);
    List<UserDto> userListToUserDtoList(List<User> users);
}
