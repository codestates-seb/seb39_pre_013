package com.codestates.server.question.service;

import com.codestates.server.question.entity.Question;
import com.codestates.server.question.repository.QuestionRepository;
import com.codestates.server.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public Question createQuestion(Question question) {

//        User user = userRepository.findById(question.getUser().getId()).get();
//        question.addUser(user);

        Question savedQuestion = questionRepository.save(question);

        return savedQuestion;
    }

    public Question updateQuestion(Question question) {
        Question foundQuestion = findVerifiedQuestion(question.getId());
        Optional.ofNullable(question.getTitle()).ifPresent(title -> foundQuestion.setTitle(title));
        Optional.ofNullable(question.getContent()).ifPresent(contents -> foundQuestion.setContent(contents));
//        Optional.ofNullable(question.getTag()).ifPresent(tag -> foundQuestion.setTag(tag));
        return foundQuestion;
    }

    public Question findQuestion(long questionId) {
        return findVerifiedQuestion(questionId);
    }

    public Page<Question> findQuestions(int page, int size) {
        return questionRepository.findAll(PageRequest.of(page, size));
    }

    public void deleteQuestion(long questionId) {
        Question foundQuestion = findVerifiedQuestion(questionId);
        questionRepository.delete(foundQuestion);
    }

    public Question findVerifiedQuestion(long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        return optionalQuestion.orElseThrow(() -> new RuntimeException("Question Not Found"));
    }
}
