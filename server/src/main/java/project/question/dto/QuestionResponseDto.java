package project.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import project.question.entity.Tag;
import project.question.entity.User;

@Getter
@Setter
@AllArgsConstructor
public class QuestionResponseDto {
    private long id;
    private String title;
    private String contents;
    private Tag tag;
    private int view;
    private int vote;
    private User user;
}
