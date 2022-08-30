package project.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import project.tag.entity.Tag;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class QuestionPostDto {
    private String title;
    private String content;
    private List<Tag> tags;
}
