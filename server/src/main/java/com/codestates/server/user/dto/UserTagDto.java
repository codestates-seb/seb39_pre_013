package com.codestates.server.user.dto;

import com.codestates.server.tag.dto.TagDto;
import com.codestates.server.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserTagDto {
    private Long id;
    private String name;

    private UserDto user;
    private TagDto tag;
}
