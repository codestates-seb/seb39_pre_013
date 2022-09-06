package com.codestates.server.user.dto;

import com.codestates.server.tag.dto.TagDto;
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
