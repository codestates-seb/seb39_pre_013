//package com.codestates.server.unit;
//
//
//import com.codestates.server.user.controller.UserApiContoller;
//import com.codestates.server.user.dto.TagDto;
//import com.codestates.server.user.dto.UserRequestDto;
//import com.codestates.server.user.dto.UserResponseDto;
//import com.codestates.server.user.entity.User;
//import com.codestates.server.user.mapper.UserMapper;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
//
//import java.util.ArrayList;
//
//
//@SpringBootTest
//public class MapstructTest {
//    @Autowired
//    private  UserMapper userMapper;
//
//    @DisplayName("1. ")
//    @Test
//    void test_1(){
//
//        ArrayList<TagDto> tags = new ArrayList<>(){{
//            add(new TagDto("java"));
//            add(new TagDto("javascript"));
//            add(new TagDto("python"));
//        }};
//        UserRequestDto.signUp requestBody = new UserRequestDto.signUp("kws3363@gmail.com","abcd@efg","김수보",tags);
//        System.out.println(requestBody.toString());
//        UserResponseDto userResponseDto = UserResponseDto.builder().id(1L).email("kws3363@gmail.com").nickname("김수보").build();
//        System.out.println(userMapper.signUpDtoToUserEntity(requestBody));
//        User user = userMapper.signUpDtoToUserEntity(requestBody) ;
//        System.out.println(user.toString());
//    }
//
//}
