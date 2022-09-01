package project.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import project.question.dto.QuestionResponseDto;
import project.question.entity.Question;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String email;
    private String nickname;
    private Long reputation;
//    private List<Question> questions;
}
