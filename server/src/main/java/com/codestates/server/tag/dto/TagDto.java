package com.codestates.server.tag.dto;

import com.codestates.server.user.dto.UserTagDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TagDto {
    private Long id;
    private String name;
    private String description;

    private List<UserTagDto> userTags;
}
