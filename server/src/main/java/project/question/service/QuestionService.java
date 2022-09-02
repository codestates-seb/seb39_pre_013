package project.question.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import project.question.entity.Question;
import project.question.repository.QuestionRepository;
import project.user.entity.User;
import project.user.repository.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
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
        return questionRepository.save(foundQuestion);
    }

    public Question findQuestion(long questionId) {
        return findVerifiedQuestion(questionId);
    }

    public Page<Question> findQuestions(int page, int size) {
        return questionRepository.findAll(PageRequest.of(page, size));
    }

    public void deleteQuestion(long questionId) {
        System.out.println(2);
        System.out.println("questionId = " + questionId);
        Question foundQuestion = findVerifiedQuestion(questionId);
        System.out.println("foundQuestion = " + foundQuestion);
        System.out.println(3);
        questionRepository.delete(foundQuestion);
        System.out.println(4);
    }

    public Question findVerifiedQuestion(long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        return optionalQuestion.orElseThrow(() -> new RuntimeException("Question Not Found"));
    }
}
