package com.codestates.server.answer.controller;

import com.codestates.server.answer.entity.Answer;
import com.codestates.server.common.dto.SingleResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codestates.server.answer.dto.AnswerPatchDto;
import com.codestates.server.answer.dto.AnswerPostDto;
import com.codestates.server.answer.mapper.AnswerMapper;
import com.codestates.server.answer.service.AnswerService;

@RestController
@RequestMapping("/api/v1/answers")
@AllArgsConstructor
public class AnswerController {
    private final AnswerService answerService;
    private final AnswerMapper answerMapper;

    @PostMapping
    public ResponseEntity postAnswer(@RequestBody AnswerPostDto answerPostDto) {
        Answer answer = answerMapper.answerPostDtoToAnswer(answerPostDto);
        Answer response = answerService.createAnswer(answer);
        return new ResponseEntity(
                new SingleResponseDto<>(answerMapper.answerToAnswerResponseDto(response)), HttpStatus.CREATED);
    }

    @PatchMapping("/{answer-id}")
    public ResponseEntity patchAnswer(@PathVariable("answer-id") long answerId,
                                      @RequestBody AnswerPatchDto answerPatchDto) {
        answerPatchDto.setId(answerId);
        Answer answer = answerMapper.answerPatchDtoToAnswer(answerPatchDto);
        Answer response = answerService.updateAnswer(answer);
        return new ResponseEntity<>(
                new SingleResponseDto<>(answerMapper.answerToAnswerResponseDto(response)), HttpStatus.OK);
    }

    @DeleteMapping("/{answer-id}")
    public ResponseEntity deleteAnswer(@PathVariable("answer-id") long answerId) {
        answerService.deleteAnswer(answerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
