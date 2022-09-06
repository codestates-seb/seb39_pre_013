package com.codestates.server.subscribe.controller;

import com.codestates.server.common.dto.SingleResponseDto;
import com.codestates.server.subscribe.entity.Subscribe;
import com.codestates.server.subscribe.repository.SubscribeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscribe")
public class SubscribeController {
    private final SubscribeRepository subscribeRepository;

    @GetMapping("/{subscribeId}")
    public ResponseEntity<?> getSubscribe(@PathVariable("subscribeId") Long id){
        Subscribe subscribe = subscribeRepository.findById(id).orElseThrow();
        String questionTitle = subscribe.getQuestion().getTitle();
        String answer = subscribe.getAnswer().getContent();

        return new ResponseEntity<>(
                new SingleResponseDto<>(new HashMap<>() {{
                    put("questionTitle", questionTitle);
                    put("answer", answer);
                }}), HttpStatus.OK);
    }
}
