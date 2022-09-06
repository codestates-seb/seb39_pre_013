package com.codestates.server.comment.controller;

import com.codestates.server.common.dto.SingleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codestates.server.comment.dto.CommentPatchDto;
import com.codestates.server.comment.dto.CommentPostDto;
import com.codestates.server.comment.entity.Comment;
import com.codestates.server.comment.mapper.CommentMapper;
import com.codestates.server.comment.service.CommentService;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final CommentMapper commentMapper;

    @PostMapping
    public ResponseEntity createComment(@RequestBody CommentPostDto commentPostDto) {
        System.out.println("commentPostDto = " + commentPostDto);
        Comment comment = commentMapper.commentPostDtoToComment(commentPostDto);
        System.out.println("comment = " + comment);
        Comment response = commentService.createComment(comment);
        System.out.println("response = " + response);
        return new ResponseEntity<>(
                new SingleResponseDto<>(commentMapper.commentToCommentResponseDto(response)), HttpStatus.CREATED);
    }

    @PatchMapping("/{comment-id}")
    public ResponseEntity updateComment(@PathVariable("comment-id") long commentId,
                                        @RequestBody CommentPatchDto commentPatchDto) {
        commentPatchDto.setId(commentId);
        Comment comment = commentMapper.commentPatchDtoToComment(commentPatchDto);
        Comment response = commentService.updateComment(comment);
        return new ResponseEntity<>(
                new SingleResponseDto<>(commentMapper.commentToCommentResponseDto(response)), HttpStatus.OK);
    }

    @DeleteMapping("/{comment-id}")
    public ResponseEntity deleteComment(@PathVariable("comment-id") long commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
