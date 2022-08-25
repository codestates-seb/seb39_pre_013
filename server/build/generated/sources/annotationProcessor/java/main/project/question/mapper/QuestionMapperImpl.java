package project.question.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import project.question.dto.QuestionPatchDto;
import project.question.dto.QuestionPostDto;
import project.question.dto.QuestionResponseDto;
import project.question.entity.Question;
import project.question.entity.Tag;
import project.question.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-25T22:22:47+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 11.0.15 (Azul Systems, Inc.)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public Question questionPostDtoToQuestion(QuestionPostDto questionPostDto) {
        if ( questionPostDto == null ) {
            return null;
        }

        Question question = new Question();

        return question;
    }

    @Override
    public Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto) {
        if ( questionPatchDto == null ) {
            return null;
        }

        Question question = new Question();

        return question;
    }

    @Override
    public QuestionResponseDto questionToQuestionResponseDto(Question question) {
        if ( question == null ) {
            return null;
        }

        long id = 0L;
        String title = null;
        String contents = null;
        Tag tag = null;
        int view = 0;
        int vote = 0;
        User user = null;

        id = question.getId();
        title = question.getTitle();
        contents = question.getContents();
        tag = question.getTag();
        view = question.getView();
        vote = question.getVote();
        user = question.getUser();

        QuestionResponseDto questionResponseDto = new QuestionResponseDto( id, title, contents, tag, view, vote, user );

        return questionResponseDto;
    }

    @Override
    public List<QuestionResponseDto> questionsToQuestionResponseDtos(List<Question> questions) {
        if ( questions == null ) {
            return null;
        }

        List<QuestionResponseDto> list = new ArrayList<QuestionResponseDto>( questions.size() );
        for ( Question question : questions ) {
            list.add( questionToQuestionResponseDto( question ) );
        }

        return list;
    }
}
