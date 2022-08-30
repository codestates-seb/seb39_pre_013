package com.codestates.server.user.controller;

import com.codestates.server.common.dto.MultiResponseDto;
import com.codestates.server.common.dto.ResponseDto;
import com.codestates.server.user.dto.UserRequestDto;
import com.codestates.server.user.dto.UserDto;
import com.codestates.server.user.entity.User;
import com.codestates.server.user.mapper.UserMapper;
import com.codestates.server.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/users")
public class UserApiContoller {
    private final UserMapper userMapper;
    private final UserService userService;
    public UserApiContoller(UserMapper userMapper, UserService userService  ) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    //[Signin][COMMON-O1-SINGIN-01] - 회원가입
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserRequestDto.signUp requestBody){
        User user = setUser(requestBody);
        User createdUser = userService.createUser(user);
        UserDto userDto = userMapper.userEntityToUserDto(createdUser);
        return new ResponseEntity<>(new ResponseDto<>(userDto), HttpStatus.CREATED);
    }
    //[Login][COMMON-O1-LOGIN-01] - 이메일 로그인
    //만들필요없음 ..jwt로 구현해놨기 때문에

    //[Question][USER-O1-QUE-06] - 질문을 등록한 유저 정보 조회
    @GetMapping("/{user-id}")
    public ResponseEntity<?> getUser(@PathVariable("user-id") Long userId){
        User findUser = userService.findUser(userId).orElseThrow();
        UserDto userDto = userMapper.userEntityToUserDto(findUser);

        return new ResponseEntity<>(new ResponseDto<>(userDto)
                ,HttpStatus.OK);
    }
    //[User][USER-O1-USERS-02] 전체 유저 조회

    @GetMapping
    public ResponseEntity<?> getUserPage(@Positive @RequestParam("page") int page,
                                         @Positive @RequestParam("page-size") int pageSize) {
        Page<User> pageUsers = userService.findUsers(page-1,pageSize);
        List<User> users = pageUsers.getContent();

        return new ResponseEntity<>(new MultiResponseDto<>(userMapper.userListToUserDtoList(users)
                ,pageUsers)
                ,HttpStatus.OK);
    }

    private User setUser(UserRequestDto.signUp requestBody) {
        User user = userMapper.signUpDtoToUserEntity(requestBody);
        return user;
    }
}
