package com.codestates.server.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codestates.server.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
