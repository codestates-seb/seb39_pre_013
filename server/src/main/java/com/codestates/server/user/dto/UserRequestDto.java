package com.codestates.server.user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class UserRequestDto {

//    @ToString
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @ToString
    public static class signUp {
        private String email;
        private String password;
        private String nickname;
        private List<UserTagDto> userTags = new ArrayList<>();

        public signUp(String email, String password, String nickname, List<UserTagDto> userTags) {
            this.email = email;
            this.password = password;
            this.nickname = nickname;
            this.userTags = userTags==null? new ArrayList<>() : userTags;
        }
    }

//    @Getter
//    @NoArgsConstructor(access = AccessLevel.PROTECTED)
//    public static class login{
//        private String email;
//        private String password;
//
//    }


}
