package project.answer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.answer.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
