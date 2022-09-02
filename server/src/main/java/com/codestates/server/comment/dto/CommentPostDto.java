package project.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data
public class CommentPostDto {
    private Long questionId;
    private Long answerId;
    private Long userId;
    private String content;
}
