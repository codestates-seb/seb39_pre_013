package project.question.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.answer.entity.Answer;
import project.comment.entity.Comment;
import project.tag.entity.Tag;
import project.user.entity.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private int view;

    private int vote;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "question")
    private List<Tag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "question")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime modifiedAt = LocalDateTime.now();
}
