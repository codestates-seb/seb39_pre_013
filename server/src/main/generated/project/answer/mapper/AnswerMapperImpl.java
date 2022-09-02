package project.answer.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import project.answer.dto.AnswerPatchDto;
import project.answer.dto.AnswerPostDto;
import project.answer.dto.AnswerResponseDto;
import project.answer.entity.Answer;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-31T11:09:14+0900",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 11.0.15 (Azul Systems, Inc.)"
)
@Component
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto) {
        if ( answerPostDto == null ) {
            return null;
        }

        Answer answer = new Answer();

        answer.setContent( answerPostDto.getContent() );

        return answer;
    }

    @Override
    public Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto) {
        if ( answerPatchDto == null ) {
            return null;
        }

        Answer answer = new Answer();

        answer.setId( answerPatchDto.getId() );
        answer.setContent( answerPatchDto.getContent() );

        return answer;
    }

    @Override
    public AnswerResponseDto answerToAnswerResponseDto(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        long id = 0L;
        String content = null;
        int recommendation = 0;

        if ( answer.getId() != null ) {
            id = answer.getId();
        }
        content = answer.getContent();
        if ( answer.getRecommendation() != null ) {
            recommendation = answer.getRecommendation();
        }

        AnswerResponseDto answerResponseDto = new AnswerResponseDto( id, content, recommendation );

        return answerResponseDto;
    }
}
