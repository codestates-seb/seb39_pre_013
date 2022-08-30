package com.codestates.server.tag.dto;

import com.codestates.server.user.dto.UserDto;
import com.codestates.server.user.dto.UserTagDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TagDto {
    private Long id;
    private String name;
    private String description;

    private List<UserTagDto> userTags;
    private UserDto user;
}
