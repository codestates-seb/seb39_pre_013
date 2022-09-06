package com.codestates.server.question.repository;

import com.codestates.server.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    List<Question> findByUserId(Long userId);
}
