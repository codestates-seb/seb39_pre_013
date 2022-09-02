package project.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import com.codestates.server.comment.dto.CommentResponseDto;
import com.codestates.server.user.dto.UserResponseDto;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Data
public class AnswerResponseDto {
    private long id;
    private String content;
    private int recommendation;
    private UserResponseDto user;
    private List<CommentResponseDto> comments;
}
