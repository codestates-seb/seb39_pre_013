package com.codestates.server.unit;


import com.codestates.server.question.entity.Question;
import com.codestates.server.question.service.QuestionRepository;
import com.codestates.server.user.entity.User;
import com.codestates.server.user.mapper.UserMapper;
import com.codestates.server.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;


@SpringBootTest
public class MapstructTest {
    @Autowired
    private  UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private QuestionRepository questionRepository;
    @DisplayName("1. ")
    @Test
    void test_1(){
        Optional<User> user = userService.findUser(1L);
        List<Question> questions =  questionRepository.findByUserId(1L);
        System.out.println(user.toString());
        questions.stream().forEach(System.out::println);
    }


}
