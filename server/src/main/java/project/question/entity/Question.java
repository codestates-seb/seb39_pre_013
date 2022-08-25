package project.question.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private long id;
    private String title;
    private String contents;
    private Tag tag;
    private int view;
    private int vote;
    private User user;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
}
