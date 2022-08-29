package com.codestates.server.user.controller;

import com.codestates.server.common.dto.ResponseDto;
import com.codestates.server.user.dto.UserRequestDto;
import com.codestates.server.user.dto.UserResponseDto;
import com.codestates.server.user.entity.User;
import com.codestates.server.user.mapper.UserMapper;
import com.codestates.server.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserApiContoller {
    private final UserMapper userMapper;
    private final UserService userService;
    public UserApiContoller(UserMapper userMapper, UserService userService  ) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    //[Signin][COMMON-O1-SINGIN-01] - 회원가입
    @PostMapping("/users/signup")
    public ResponseEntity<?> signup(@RequestBody UserRequestDto.signUp requestBody){
        User user = setUser(requestBody);
        User createdUser = userService.createUser(user);
        UserResponseDto userResponseDto = userMapper.userEntityToResponseDto(createdUser);
        return new ResponseEntity<>(new ResponseDto<>(userResponseDto), HttpStatus.CREATED);
    }

    private User setUser(UserRequestDto.signUp requestBody) {
        User user = userMapper.signUpDtoToUserEntity(requestBody);
        return user;
    }

    //[Login][COMMON-O1-LOGIN-01] - 이메일 로그인
    //만들필요없음 ..jwt로 구현해놨기 때문에

    //[Home][USER-O1-QUE-03] - 질문 상세조회

    //[Home][USER-O1-QUE-05] - 전체 질문 조회

    //[Question][USER-O1-QUE-06] - 질문을 등록한 유저 정보 조회

    //[User][USER-O1-USERS-02] 전체 유저 조회
}
