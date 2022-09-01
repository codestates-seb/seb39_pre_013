package project.answer.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.comment.entity.Comment;
import project.question.entity.Question;
import project.user.entity.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
//    @JsonManagedReference
//    @JsonBackReference
    private Question question;

    public void addQuestion(Question question) {
        this.question = question;
        if (!this.question.getAnswers().contains(this)) {
            this.question.getAnswers().add(this);
        }
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
//    @JsonManagedReference
//    @JsonBackReference
    private User user;

    public void addUser(User user) {
        this.user = user;
        if (!this.user.getAnswers().contains(this)) {
            this.user.getAnswers().add(this);
        }
    }

    @OneToMany(mappedBy = "answer")
    private List<Comment> comments = new ArrayList<>();

    private Integer recommendation;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime modifiedAt = LocalDateTime.now();
}
