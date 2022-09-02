package project.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import project.question.entity.QuestionTag;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class QuestionPatchDto {
    private Long id;
    private String title;
    private String content;
    private List<QuestionTag> questionTags;
}
