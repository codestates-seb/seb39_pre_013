package com.codestates.server.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.codestates.server.comment.entity.Comment;
import com.codestates.server.comment.repository.CommentRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        //todo mapstruct 에서 제외 시키는 방법 검색
        if (comment.getAnswer().getId() == null) comment.setAnswer(null);
        if (comment.getQuestion().getId() == null) comment.setQuestion(null);

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
