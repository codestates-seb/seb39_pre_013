package project.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.question.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
