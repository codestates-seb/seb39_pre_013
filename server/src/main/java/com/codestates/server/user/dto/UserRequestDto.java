package com.codestates.server.user.dto;

import com.codestates.server.tag.dto.TagDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
        private List<TagDto> tags;

        public signUp(String email, String password, String nickname, List<TagDto> tags) {
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


}
