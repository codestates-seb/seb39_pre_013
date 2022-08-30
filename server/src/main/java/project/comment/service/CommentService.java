package project.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.comment.entity.Comment;
import project.comment.repository.CommentRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment) {
        Comment foundComment = findVerifiedComment(comment.getId());
        Optional.ofNullable(comment.getContent()).ifPresent(content -> foundComment.setContent(content));
        return commentRepository.save(foundComment);
    }

    public void deleteComment(long commentId) {
        Comment foundComment = findVerifiedComment(commentId);
        commentRepository.delete(foundComment);
    }

    public Comment findVerifiedComment(long commentId) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        return optionalComment.orElseThrow(() -> new RuntimeException("Comment Not Found"));
    }
}
