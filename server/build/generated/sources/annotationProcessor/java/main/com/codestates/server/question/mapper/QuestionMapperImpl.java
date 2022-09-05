package com.codestates.server.question.mapper;

import com.codestates.server.answer.dto.AnswerResponseDto;
import com.codestates.server.answer.entity.Answer;
import com.codestates.server.comment.dto.CommentResponseDto;
import com.codestates.server.comment.entity.Comment;
import com.codestates.server.question.dto.QuestionPatchDto;
import com.codestates.server.question.dto.QuestionPostDto;
import com.codestates.server.question.dto.QuestionResponseDto;
import com.codestates.server.question.dto.QuestionTagResponseDto;
import com.codestates.server.question.entity.Question;
import com.codestates.server.question.entity.QuestionTag;
import com.codestates.server.user.dto.UserResponseDto;
import com.codestates.server.user.entity.User;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-05T14:21:40+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public Question questionPostDtoToQuestion(QuestionPostDto questionPostDto) {
        if ( questionPostDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setUser( questionPostDtoToUser( questionPostDto ) );
        question.setTitle( questionPostDto.getTitle() );
        question.setContent( questionPostDto.getContent() );
        List<QuestionTag> list = questionPostDto.getQuestionTags();
        if ( list != null ) {
            question.setQuestionTags( new ArrayList<QuestionTag>( list ) );
        }

        return question;
    }

    @Override
    public Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto) {
        if ( questionPatchDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setId( questionPatchDto.getId() );
        question.setTitle( questionPatchDto.getTitle() );
        question.setContent( questionPatchDto.getContent() );
        List<QuestionTag> list = questionPatchDto.getQuestionTags();
        if ( list != null ) {
            question.setQuestionTags( new ArrayList<QuestionTag>( list ) );
        }

        return question;
    }

    @Override
    public QuestionResponseDto questionToQuestionResponseDto(Question question) {
        if ( question == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String content = null;
        Integer view = null;
        Integer vote = null;
        UserResponseDto user = null;
        List<QuestionTagResponseDto> questionTags = null;
        List<CommentResponseDto> comments = null;
        List<AnswerResponseDto> answers = null;
        LocalDateTime createdAt = null;
        LocalDateTime modifiedAt = null;

        id = question.getId();
        title = question.getTitle();
        content = question.getContent();
        view = question.getView();
        vote = question.getVote();
        user = userToUserResponseDto( question.getUser() );
        questionTags = questionTagsToQuestionTagResponseDtos( question.getQuestionTags() );
        comments = commentToCommentResponseDtos( question.getComments() );
        answers = answersToAnswerResponseDtos( question.getAnswers() );
        createdAt = question.getCreatedAt();
        modifiedAt = question.getModifiedAt();

        QuestionResponseDto questionResponseDto = new QuestionResponseDto( id, title, content, view, vote, user, questionTags, comments, answers, createdAt, modifiedAt );

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

    @Override
    public UserResponseDto userToUserResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String email = null;
        String nickname = null;
        Long reputation = null;

        id = user.getId();
        email = user.getEmail();
        nickname = user.getNickname();
        reputation = user.getReputation();

        UserResponseDto userResponseDto = new UserResponseDto( id, email, nickname, reputation );

        return userResponseDto;
    }

    @Override
    public List<AnswerResponseDto> answersToAnswerResponseDtos(List<Answer> answers) {
        if ( answers == null ) {
            return null;
        }

        List<AnswerResponseDto> list = new ArrayList<AnswerResponseDto>( answers.size() );
        for ( Answer answer : answers ) {
            list.add( answerToAnswerResponseDto( answer ) );
        }

        return list;
    }

    @Override
    public List<CommentResponseDto> commentToCommentResponseDtos(List<Comment> comments) {
        if ( comments == null ) {
            return null;
        }

        List<CommentResponseDto> list = new ArrayList<CommentResponseDto>( comments.size() );
        for ( Comment comment : comments ) {
            list.add( commentToCommentResponseDto( comment ) );
        }

        return list;
    }

    @Override
    public List<QuestionTagResponseDto> questionTagsToQuestionTagResponseDtos(List<QuestionTag> questionTags) {
        if ( questionTags == null ) {
            return null;
        }

        List<QuestionTagResponseDto> list = new ArrayList<QuestionTagResponseDto>( questionTags.size() );
        for ( QuestionTag questionTag : questionTags ) {
            list.add( questionTagToQuestionTagResponseDto( questionTag ) );
        }

        return list;
    }

    protected User questionPostDtoToUser(QuestionPostDto questionPostDto) {
        if ( questionPostDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( questionPostDto.getUserId() );

        return user.build();
    }

    protected AnswerResponseDto answerToAnswerResponseDto(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        long id = 0L;
        String content = null;
        int recommendation = 0;
        UserResponseDto user = null;
        List<CommentResponseDto> comments = null;

        if ( answer.getId() != null ) {
            id = answer.getId();
        }
        content = answer.getContent();
        if ( answer.getRecommendation() != null ) {
            recommendation = answer.getRecommendation();
        }
        user = userToUserResponseDto( answer.getUser() );
        comments = commentToCommentResponseDtos( answer.getComments() );

        AnswerResponseDto answerResponseDto = new AnswerResponseDto( id, content, recommendation, user, comments );

        return answerResponseDto;
    }

    protected CommentResponseDto commentToCommentResponseDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        long id = 0L;
        String content = null;
        UserResponseDto user = null;
        LocalDateTime modifiedAt = null;

        if ( comment.getId() != null ) {
            id = comment.getId();
        }
        content = comment.getContent();
        user = userToUserResponseDto( comment.getUser() );
        modifiedAt = comment.getModifiedAt();

        CommentResponseDto commentResponseDto = new CommentResponseDto( id, content, user, modifiedAt );

        return commentResponseDto;
    }

    protected QuestionTagResponseDto questionTagToQuestionTagResponseDto(QuestionTag questionTag) {
        if ( questionTag == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = questionTag.getId();
        name = questionTag.getName();

        QuestionTagResponseDto questionTagResponseDto = new QuestionTagResponseDto( id, name );

        return questionTagResponseDto;
    }
}
