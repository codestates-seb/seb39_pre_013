package project.question.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.tag.entity.Tag;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class QuestionTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TAG_ID")
    private Tag tag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

//    public void setQuestion(Question question){
//        this.question = question;
//        if (!this.question.getQuestionTags().contains(this)) {
//            this.question.getQuestionTags().add(this);
//        }
//    }
}
