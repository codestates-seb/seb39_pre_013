package project.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
