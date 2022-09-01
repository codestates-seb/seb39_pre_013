package project.comment.mapper;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import project.comment.dto.CommentPatchDto;
import project.comment.dto.CommentPostDto;
import project.comment.dto.CommentResponseDto;
import project.comment.entity.Comment;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-31T11:09:15+0900",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 11.0.15 (Azul Systems, Inc.)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment commentPostDtoToComment(CommentPostDto commentPostDto) {
        if ( commentPostDto == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setContent( commentPostDto.getContent() );

        return comment;
    }

    @Override
    public Comment commentPatchDtoToComment(CommentPatchDto commentPatchDto) {
        if ( commentPatchDto == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setId( commentPatchDto.getId() );
        comment.setContent( commentPatchDto.getContent() );

        return comment;
    }

    @Override
    public CommentResponseDto commentToCommentResponseDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        long id = 0L;
        String content = null;
        LocalDateTime modifiedAt = null;

        if ( comment.getId() != null ) {
            id = comment.getId();
        }
        content = comment.getContent();
        modifiedAt = comment.getModifiedAt();

        CommentResponseDto commentResponseDto = new CommentResponseDto( id, content, modifiedAt );

        return commentResponseDto;
    }
}
