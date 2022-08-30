package project.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import project.tag.entity.Tag;

@Getter
@Setter
@AllArgsConstructor
public class QuestionResponseDto {
    private long id;
    private String title;
    private String content;
    private Tag tag;
    private int view;
    private int vote;
//    private User user;
}