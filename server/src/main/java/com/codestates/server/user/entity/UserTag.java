package com.codestates.server.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class UserTag {
    private Long userId;
    private Long tagId;
    private String name;
}
