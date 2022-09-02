package project.question.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import project.answer.dto.AnswerResponseDto;
import project.comment.dto.CommentResponseDto;
import project.user.dto.UserResponseDto;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Data
public class QuestionResponseDto {
    private Long id;
    private String title;
    private String content;
    private Integer view;
    private Integer vote;
    private UserResponseDto user;
    private List<QuestionTagResponseDto> questionTags;
    private List<CommentResponseDto> comments;
    private List<AnswerResponseDto> answers;
    private LocalDateTime modifiedAt;
}
