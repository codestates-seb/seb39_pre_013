package com.codestates.server.question.mapper;

import com.codestates.server.question.dto.QuestionDto;
import com.codestates.server.question.entity.Question;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface QuestionMapper {

    @Named("QuestionIgnoreUser")
    @Mapping(target = "user",ignore = true)
    QuestionDto questionToQuestionDto(Question question);

    @IterableMapping(qualifiedByName = "QuestionIgnoreUser")
    List<QuestionDto> questionListToQuestionDtos(List<Question> questions);
}


// 어느단계
// 영단어처럼 구분이 안되요
//