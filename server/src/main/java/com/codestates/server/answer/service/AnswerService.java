package com.codestates.server.answer.service;

import com.codestates.server.answer.entity.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.codestates.server.answer.repository.AnswerRepository;
import com.codestates.server.question.service.QuestionService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionService questionService;

    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public Answer updateAnswer(Answer answer) {
        Answer foundAnswer = findVerifiedAnswer(answer.getId());
        Optional.ofNullable(answer.getContent()).ifPresent(content -> foundAnswer.setContent(content));
        return answerRepository.save(foundAnswer);
    }

    public void deleteAnswer(long answerId) {
        Answer foundAnswer = findVerifiedAnswer(answerId);
        answerRepository.delete(foundAnswer);
    }

    public Answer findVerifiedAnswer(long answerId) {
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
        return optionalAnswer.orElseThrow(() -> new RuntimeException("Answer Not Found"));
    }
}
