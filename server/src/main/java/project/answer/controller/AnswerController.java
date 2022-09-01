package project.answer.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.answer.dto.AnswerPatchDto;
import project.answer.dto.AnswerPostDto;
import project.answer.entity.Answer;
import project.answer.mapper.AnswerMapper;
import project.answer.service.AnswerService;
import project.dto.SingleResponseDto;
import project.question.entity.Question;
import project.question.service.QuestionService;

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
