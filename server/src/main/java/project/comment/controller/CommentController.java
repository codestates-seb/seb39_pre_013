package project.comment.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.comment.dto.CommentPatchDto;
import project.comment.dto.CommentPostDto;
import project.comment.entity.Comment;
import project.comment.mapper.CommentMapper;
import project.comment.service.CommentService;
import project.dto.SingleResponseDto;

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
