package project.comment.mapper;

import org.mapstruct.*;
import project.comment.dto.CommentPatchDto;
import project.comment.dto.CommentPostDto;
import project.comment.dto.CommentResponseDto;
import project.comment.entity.Comment;
import com.codestates.server.user.dto.UserResponseDto;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        nullValueMapMappingStrategy =  NullValueMappingStrategy.RETURN_NULL)
public interface CommentMapper {
    @Mapping(source = "questionId", target = "question.id")
//    @Mapping(target = "user.email", ignore = true)
    @Mapping(source = "answerId", target = "answer.id")
//    @Mapping(target = "answer", ignore = true)
    @Mapping(source = "userId", target = "user.id")
    Comment commentPostDtoToComment(CommentPostDto commentPostDto);

    Comment commentPatchDtoToComment(CommentPatchDto commentPatchDto);

    CommentResponseDto commentToCommentResponseDto(Comment comment);

    @InheritInverseConfiguration
    UserResponseDto userToUserResponseDto(User user);
}
