package project.question.service;

import org.springframework.stereotype.Service;
import project.question.entity.Question;

import java.util.List;

@Service
public class QuestionService {
    public Question createQuestion(Question question) {
        return question;
    }

    public Question updateQuestion(Question question) {
        return question;
    }

    public Question findQuestion(long questionId) {
        return new Question();
    }

    public List<Question> findQuestions(int page, int size) {
        return List.of(
                new Question(),
                new Question()
        );
    }

    public void deleteQuestion(long questionId) {

    }
}
