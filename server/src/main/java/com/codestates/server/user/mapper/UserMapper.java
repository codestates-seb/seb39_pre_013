package com.codestates.server.user.mapper;

import com.codestates.server.user.dto.TagDto;
import com.codestates.server.user.dto.UserRequestDto;
import com.codestates.server.user.dto.UserResponseDto;
import com.codestates.server.user.entity.Tag;
import com.codestates.server.user.entity.User;
import com.codestates.server.user.entity.UserTag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User signUpDtoToUserEntity(UserRequestDto.signUp dto);
    //우선 TagDto - > UserTag로 바꾸고 ->  Tag로 바꾼다.
    UserTag tagToDto(TagDto tag);
    Tag userTagToTag(UserTag userTag);

    UserResponseDto userEntityToResponseDto(User user);
}
