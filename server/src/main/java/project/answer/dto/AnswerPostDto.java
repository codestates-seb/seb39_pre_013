package project.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data
public class AnswerPostDto {
//    @Mapper
    private Long questionId;
    private Long userId;
    private String content;
}
