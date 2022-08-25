package project.question.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Tag {
    JAVA("Java", "java is ..."),
    JAVASCRIPT("Javascript", "Javascript is ...");

    private String name;
    private String description;
}
