package com.codestates.server.unit;


import com.codestates.server.user.dto.TagDto;
import com.codestates.server.user.dto.UserDto;
import com.codestates.server.user.dto.UserRequestDto;
import com.codestates.server.user.entity.User;
import com.codestates.server.user.mapper.UserMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;


@SpringBootTest
public class MapstructTest {
    @Autowired
    private  UserMapper userMapper;

    @DisplayName("1. ")
    @Test
    void test_1(){

        ArrayList<TagDto> tags = new ArrayList<>(){{
            add(new TagDto("java"));
            add(new TagDto("javascript"));
            add(new TagDto("python"));
        }};
        UserRequestDto.signUp requestBody = new UserRequestDto.signUp("kws3363@gmail.com","abcd@efg","김수보",tags);
        System.out.println(requestBody.toString());
        UserDto userDto = UserDto.builder().id(1L).email("kws3363@gmail.com").nickname("김수보").build();
        System.out.println(userMapper.signUpDtoToUserEntity(requestBody));
        User user = userMapper.signUpDtoToUserEntity(requestBody) ;
        System.out.println(user.toString());
    }


}
