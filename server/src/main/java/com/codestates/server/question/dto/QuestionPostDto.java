package project.question.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import project.question.entity.QuestionTag;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Data
public class QuestionPostDto {
    private Long userId;
    private String title;
    private String content;
    private List<QuestionTag> questionTags;
}
