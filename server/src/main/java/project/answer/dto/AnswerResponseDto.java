package project.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import project.user.dto.UserResponseDto;

@Getter
@Setter
@AllArgsConstructor
@Data
public class AnswerResponseDto {
    private long id;
    private String content;
    private int recommendation;
    private UserResponseDto user;
}
