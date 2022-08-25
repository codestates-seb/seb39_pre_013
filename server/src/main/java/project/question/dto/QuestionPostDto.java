package project.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import project.question.entity.Tag;

@Getter
@Setter
@AllArgsConstructor
public class QuestionPostDto {
    private String title;
    private String contents;
    private Tag tag;
}
