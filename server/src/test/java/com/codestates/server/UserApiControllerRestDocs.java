//package com.codestates.server;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.codestates.server.user.controller.UserApiContoller;
//import com.codestates.server.user.dto.ResponseTagDto;
//import com.codestates.server.user.dto.UserDto;
//import com.codestates.server.user.dto.UserRequestDto;
//import com.codestates.server.user.entity.User;
//import com.codestates.server.user.mapper.UserMapper;
//import com.codestates.server.user.service.UserService;
//import com.codestates.server.util.LoginDto;
//import com.google.gson.Gson;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
//import org.springframework.http.MediaType;
//import org.springframework.restdocs.payload.JsonFieldType;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static com.codestates.server.util.ApiDocumentUtils.getRequestPreProcessor;
//import static com.codestates.server.util.ApiDocumentUtils.getResponsePreProcessor;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
//import static org.springframework.restdocs.payload.PayloadDocumentation.*;
//import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(UserApiContoller.class)
//@MockBean(JpaMetamodelMappingContext.class)
//@AutoConfigureRestDocs
//@AutoConfigureMockMvc(addFilters = false)
//public class UserApiControllerRestDocs {
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private UserService userService;
//    @MockBean
//    private UserMapper userMapper;
//    @Autowired
//    private Gson gson;
//    @MockBean
//    private BCryptPasswordEncoder passwordEncoder;
//    @Value("jwt.secret.key")
//    private String key;
//
//
//   @DisplayName("1. [SignUp][COMMON-O1-SIGNUP-01] - 회원가입")
//   @Test
//   void test_1() throws Exception {
//        //given
//       ArrayList<ResponseTagDto> tags = new ArrayList<>(){{
//           add(new ResponseTagDto("java"));
//           add(new ResponseTagDto("javascript"));
//           add(new ResponseTagDto("python"));
//       }};
//       UserRequestDto.signUp requestBody = new UserRequestDto.signUp("kws3363@gmail.com","abcd@efg","김수보",tags);
//       String content = gson.toJson(requestBody);
//       UserDto userDto = UserDto.builder().id(1L).email("kws3363@gmail.com").nickname("김수보").build();
//       given(userMapper.signUpDtoToUserEntity(Mockito.any(UserRequestDto.signUp.class))).willReturn(User.builder().build());
//       given(userService.createUser(Mockito.any(User.class))).willReturn(User.builder().build());
//       given(userMapper.userEntityToUserDto(Mockito.any(User.class))).willReturn(userDto);
//       System.out.println(content.toString());
//       //when
//       ResultActions actions =
//               mockMvc.perform(
//                       post("/api/v1/users/signup")
//                               .accept(MediaType.APPLICATION_JSON)
//                               .contentType(MediaType.APPLICATION_JSON)
//                               .characterEncoding("UTF-8")
//                               .content(content)
//               );
//
//       //then
//       actions.andExpect(status().isCreated())
//               .andExpect(jsonPath("$.data.id").value(1L))
//               .andExpect(jsonPath("$.data.email").value(requestBody.getEmail()))
//               .andExpect(jsonPath("$.data.nickname").value(requestBody.getNickname()))
//               .andDo(document("signUp-user",
//                       getRequestPreProcessor(),
//                       getResponsePreProcessor(),
//                       requestFields(
//                               List.of(
//                                       fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
//                                       fieldWithPath("password").type(JsonFieldType.STRING).description("비밀번호"),
//                                       fieldWithPath("nickname").type(JsonFieldType.STRING).description("닉네임"),
//                                       fieldWithPath("tags[]").type(JsonFieldType.ARRAY).optional().description("태그리스트"),
//                                       fieldWithPath("tags[].name").type(JsonFieldType.STRING).optional().description("태그 이름")
//                               )
//                       ),
//                       responseFields(
//                               List.of(
//                                       fieldWithPath("data").type(JsonFieldType.OBJECT).description("응답 데이터"),
//                                       fieldWithPath("data.id").type(JsonFieldType.NUMBER).description("응답 데이터"),
//                                       fieldWithPath("data.email").type(JsonFieldType.STRING).description("이메일"),
//                                       fieldWithPath("data.nickname").type(JsonFieldType.STRING).description("닉네임"),
//                                       fieldWithPath("data.tags[]").type(JsonFieldType.ARRAY).optional().description("태그 리스트")
//                               )
//                       )
//               ));
//
//   }
//
//   @DisplayName("2. [Login][COMMON-O1-LOGIN-01] - 이메일 로그인")
//   @Test
//   void test_2() throws Exception {
//       LoginDto loginDto = new LoginDto("kws3363@gmail.com","abcd@efg");
//       String content = gson.toJson(loginDto);
//       String jwtToken = JWT.create()
//               .withSubject("kws3363@gmail.com")
//               .withExpiresAt(new Date(System.currentTimeMillis() + (60*1000*30)))
//               .withClaim("id",1L)
//               .withClaim("nickname","김수보")
//               .sign(Algorithm.HMAC512("what_is_token_name"));
//       //given
//       ResultActions actions =
//               mockMvc.perform(
//                       post("/api/v1/users/login")
//                               .accept(MediaType.APPLICATION_JSON)
//                               .contentType(MediaType.APPLICATION_JSON)
//                               .characterEncoding("UTF-8")
//                               .content(content)
//               );
//   }
//
//
//
//
//   @DisplayName("3. [Home][USER-O1-QUE-03] - 질문 상세조회")
//   @Test
//   void test_3(){
//        //질문과
//       //유저와
//       //답변ㄷ
//   }
//
//    // 영민님은 컴포넌트별로 드리는게맞는지, 아니면 저는 명세서대로 공통의 생각을 두고
//   @DisplayName("4. [Question][USER-O1-QUE-06] - 질문을 등록한 유저 정보 조회 ")
//   @Test
//   void test_4() throws Exception {
//       Long userId = 1L;
//       //when
//       ResultActions actions = mockMvc.perform(get("/api/v1/users/{user-id}", userId));
//
//   }
//
//   @DisplayName("5. [User][USER-O1-USERS-02] 전체 유저 조회")
//   @Test
//   void test_5(){
//
//   }
//
//
//
//   //부족한정보로 그분들이 코드를 짜야한다이거죠..(1)
//    // 말로 다 대체를 해야하고.
//
//
//}
