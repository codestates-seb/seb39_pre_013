package com.codestates.server.user.dto;

import com.codestates.server.tag.dto.TagDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserTagDto {
    private UserDto user;
    private TagDto tag;
    private String name;
}
