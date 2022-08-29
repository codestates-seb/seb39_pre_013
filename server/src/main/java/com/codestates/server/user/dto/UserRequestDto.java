package com.codestates.server.user.dto;

import lombok.*;

import java.util.ArrayList;

public class UserRequestDto {

//    @ToString
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class signUp {
        private String email;
        private String password;
        private String nickname;
        private ArrayList<TagDto> tags;

        public signUp(String email, String password, String nickname, ArrayList<TagDto> tags) {
            this.email = email;
            this.password = password;
            this.nickname = nickname;
            this.tags = tags;
        }
    }

//    @Getter
//    @NoArgsConstructor(access = AccessLevel.PROTECTED)
//    public static class login{
//        private String email;
//        private String password;
//
//    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class response{

    }
}
