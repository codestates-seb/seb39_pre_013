package com.codestates.server.user.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.codestates.server.common.dto.MultiResponseDto;
import com.codestates.server.common.dto.SingleResponseDto;
import com.codestates.server.common.oauth.PrincipalDetails;
import com.codestates.server.user.dto.UserDto;
import com.codestates.server.user.dto.UserPatchDto;
import com.codestates.server.user.dto.UserRequestDto;
import com.codestates.server.user.entity.User;
import com.codestates.server.user.mapper.UserMapper;
import com.codestates.server.user.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Positive;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/users")
public class UserApiController {
    @Value("${jwt.secret.key}")
    private String JWT_KEY;

    private final UserMapper userMapper;

    private final UserService userService;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserApiController(UserMapper userMapper, UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserRequestDto.signUp requestBody){
        User user = userMapper.signUpDtoToUser(requestBody);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles("ROLE_USER");
        User createdUser = userService.createUser(user);
        UserDto userDto = userMapper.userToUserDto(createdUser);
        return new ResponseEntity<>(new SingleResponseDto<>(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<?> getUser(@PathVariable("user-id") Long userId){
        //유저아이디가 아니라 -> 토큰에서 가져와야함
        User findUser = userService.findUser(userId).orElseThrow();
        UserDto userDto = userMapper.userToUserDto(findUser);

        return new ResponseEntity<>(new SingleResponseDto<>(userDto)
                ,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> getUserPage(@Positive @RequestParam("page") int page,
                                         @Positive @RequestParam("page-size") int pageSize) {
        Page<User> pageUsers = userService.findUsers(page-1,pageSize);
        List<User> users = pageUsers.getContent();
        List<UserDto> userDtos = userMapper.userListToUserDtoList(users);
        return new ResponseEntity<>(new MultiResponseDto<>(userDtos
                ,pageUsers)
                ,HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/auth")
    public ResponseEntity<?> getMyPage(){
        PrincipalDetails principalDetails = (PrincipalDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findUser(principalDetails.getUser().getId()).orElseThrow();
        UserDto userDto = userMapper.userToUserDto(user);
        return new ResponseEntity<>(new SingleResponseDto<>(userDto),HttpStatus.OK);
    }


    @PreAuthorize("hasRole('ROLE_USER')")
    @PatchMapping("/edit")
    public ResponseEntity<?> editMyPage(@RequestBody UserPatchDto userPatchDto) {
        PrincipalDetails principalDetails = (PrincipalDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!principalDetails.getUser().getId().equals(userPatchDto.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = userService.updateUser(principalDetails.getUser().getId(),userPatchDto);
        UserDto userDto = userMapper.userToUserDto(user);
        Charset utf8 = StandardCharsets.UTF_8;
        HttpHeaders httpHeaders = new HttpHeaders();
        MediaType mediaType = new MediaType("application","json",utf8);
        httpHeaders.setContentType(mediaType);

        return new ResponseEntity<>(new SingleResponseDto<>(userDto), httpHeaders,HttpStatus.ACCEPTED);
    }

    @GetMapping("/refresh")
    public ResponseEntity<?> getRefreshToken(HttpServletRequest request, HttpServletResponse response){
        String refreshToken = request.getHeader("refresh_token").replace("Bearer ","");
        DecodedJWT refreshJwt = null;
        String username = null;
        String id = null;
        String nickname = null;

        try{
            refreshJwt = JWT.require(Algorithm.HMAC512(JWT_KEY)).build().verify(refreshToken);
        }catch (com.auth0.jwt.exceptions.TokenExpiredException e){
            response.setHeader("access_token","token expired");
            response.setHeader("refresh_token", "token expired");
            return new ResponseEntity<>(new HashMap<>(){{put("msg","refresh토큰이 만료되었습니다.");}},HttpStatus.FORBIDDEN);
        }
        String accessToken = createAccessToken(response, refreshJwt);
        response.setHeader("access_token","Bearer "+accessToken);
        response.setHeader("refresh_token","Bearer "+refreshToken);

        return new ResponseEntity<>(new HashMap<>(){{put("msg","accessToken이 재발급되었습니다.");}},HttpStatus.CREATED);
    }


    private String createAccessToken(HttpServletResponse response, DecodedJWT refreshJwt) {
        String email;
        String nickname;
        String id;
        email = refreshJwt.getClaim("email").asString();
        id = refreshJwt.getClaim("id").asString();
        nickname = refreshJwt.getClaim("nickname").asString();
        return  JWT.create()
                .withSubject(email)
                .withExpiresAt(new Date(System.currentTimeMillis() + (60 * 1000 * 30)))
                .withClaim("id", id)
                .withClaim("nickname", nickname)
                .sign(Algorithm.HMAC512(JWT_KEY));

    }

}
