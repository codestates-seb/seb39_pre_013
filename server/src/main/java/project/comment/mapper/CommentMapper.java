package project.comment.mapper;

import org.mapstruct.Mapper;
import project.comment.dto.CommentPatchDto;
import project.comment.dto.CommentPostDto;
import project.comment.dto.CommentResponseDto;
import project.comment.entity.Comment;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    Comment commentPostDtoToComment(CommentPostDto commentPostDto);

    Comment commentPatchDtoToComment(CommentPatchDto commentPatchDto);

    CommentResponseDto commentToCommentResponseDto(Comment comment);
}
