package project.question.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import project.question.entity.Question;
import project.question.repository.QuestionRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public Question createQuestion(Question question) {

        return questionRepository.save(question);
    }

    public Question updateQuestion(Question question) {
        Question foundQuestion = findVerifiedQuestion(question.getId());
        Optional.ofNullable(question.getTitle()).ifPresent(title -> foundQuestion.setTitle(title));
        Optional.ofNullable(question.getContent()).ifPresent(contents -> foundQuestion.setContent(contents));
//        Optional.ofNullable(question.getTag()).ifPresent(tag -> foundQuestion.setTag(tag));
        return questionRepository.save(foundQuestion);
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
