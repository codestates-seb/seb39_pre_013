//package project.restdocs.question;
//
//import com.google.gson.Gson;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
//import org.springframework.http.MediaType;
//import org.springframework.restdocs.payload.JsonFieldType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import project.question.controller.QuestionController;
//import project.question.dto.QuestionPatchDto;
//import project.question.dto.QuestionPostDto;
//import project.question.dto.QuestionResponseDto;
//import project.question.entity.Question;
//import project.tag.entity.Tag;
//import project.user.entity.User;
//import project.question.mapper.QuestionMapper;
//import project.question.service.QuestionService;
//
//import java.util.List;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
//import static org.springframework.restdocs.payload.PayloadDocumentation.*;
//import static org.springframework.restdocs.request.RequestDocumentation.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static project.util.APiDocumentUtils.getRequestPreProcessor;
//import static project.util.APiDocumentUtils.getResponsePreprocessor;
//
//@WebMvcTest(QuestionController.class)
//@MockBean(JpaMetamodelMappingContext.class)
//@AutoConfigureRestDocs
//public class QuestionControllerRestDocs {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private Gson gson;
//
//    @MockBean
//    private QuestionService questionService;
//
//    @MockBean
//    private QuestionMapper questionMapper;
//
//    @Test
//    public void postQuestionTest() throws Exception {
//        QuestionPostDto questionPostDto = new QuestionPostDto("How to...", "I have a..", new Tag(2L, "JAVASCRIPT", "javascript is..."));
//        String json = gson.toJson(questionPostDto);
//        QuestionResponseDto questionResponseDto = new QuestionResponseDto(1L, "How to...", "I have a..", new Tag(1L, "JAVASCRIPT", "javascript is..."), 0, 0, new User(1L, "홍길동"));
//
//
//        given(questionMapper.questionPostDtoToQuestion(Mockito.any(QuestionPostDto.class))).willReturn(new Question());
//        given(questionService.createQuestion(Mockito.any(Question.class))).willReturn(new Question());
//        given(questionMapper.questionToQuestionResponseDto(Mockito.any(Question.class))).willReturn(questionResponseDto);
//
//        ResultActions actions = mockMvc.perform(
//                post("/questions")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json)
//        );
//        actions
//                .andExpect(status().isCreated())
//                .andDo(document("post-question",
//                        getRequestPreProcessor(),
//                        getResponsePreprocessor(),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("content").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("tag").type(JsonFieldType.OBJECT).description("태그")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("id").type(JsonFieldType.NUMBER).description("질문 식별자"),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("content").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("tag").type(JsonFieldType.OBJECT).description("태그"),
//                                        fieldWithPath("tag.id").type(JsonFieldType.NUMBER).description("식별자"),
//                                        fieldWithPath("view").type(JsonFieldType.NUMBER).description("조회"),
//                                        fieldWithPath("vote").type(JsonFieldType.NUMBER).description("추천"),
//                                        fieldWithPath("user").type(JsonFieldType.OBJECT).description("작성자"),
//                                        fieldWithPath("user.id").type(JsonFieldType.NUMBER).description("식별자"),
//                                        fieldWithPath("user.name").type(JsonFieldType.STRING).description("이름")
//                                )
//                        )
//                ));
//    }
//
//    @Test
//    public void patchQuestionTest() throws Exception {
//        long questionId = 1L;
//        QuestionPatchDto questionPatchDto = new QuestionPatchDto(questionId, "How to...", "I have a..", new Tag(1L, "JAVASCRIPT", "javascript is..."));
//        String json = gson.toJson(questionPatchDto);
//        QuestionResponseDto questionResponseDto = new QuestionResponseDto(questionId, "How to...", "I have a..", new Tag(1L, "JAVASCRIPT", "javascript is..."), 0, 0, new User(1L, "홍길동"));
//
//        given(questionMapper.questionPatchDtoToQuestion(Mockito.any(QuestionPatchDto.class))).willReturn(new Question());
//        given(questionService.updateQuestion(Mockito.any(Question.class))).willReturn(new Question());
//        given(questionMapper.questionToQuestionResponseDto(Mockito.any(Question.class))).willReturn(questionResponseDto);
//
//        ResultActions actions = mockMvc.perform(
//                patch("/questions/{question-id}", questionId)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json)
//        );
//
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("patch-question",
//                        getRequestPreProcessor(),
//                        getResponsePreprocessor(),
//                        pathParameters(
//                                parameterWithName("question-id").description("질문 식별자")
//                        ),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("id").type(JsonFieldType.NUMBER).description("질문 식별자").ignored(),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목").optional(),
//                                        fieldWithPath("content").type(JsonFieldType.STRING).description("내용").optional(),
//                                        fieldWithPath("tag").type(JsonFieldType.STRING).description("태그").optional()
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("id").type(JsonFieldType.NUMBER).description("질문 식별자"),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("content").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("tag").type(JsonFieldType.STRING).description("태그"),
//                                        fieldWithPath("view").type(JsonFieldType.NUMBER).description("조회"),
//                                        fieldWithPath("vote").type(JsonFieldType.NUMBER).description("추천"),
//                                        fieldWithPath("user").type(JsonFieldType.OBJECT).description("작성자"),
//                                        fieldWithPath("user.id").type(JsonFieldType.NUMBER).description("식별자"),
//                                        fieldWithPath("user.name").type(JsonFieldType.STRING).description("이름")
//                                )
//                        )
//
//                ));
//    }
//
//    @Test
//    public void getQuestionTest() throws Exception {
//        long questionId = 1;
//        QuestionResponseDto questionResponseDto = new QuestionResponseDto(questionId, "How to...", "I have a..", new Tag(1L, "JAVASCRIPT", "javascript is..."), 0, 0, new User(1L, "홍길동"));
//
//        given(questionService.findQuestion(Mockito.anyLong())).willReturn(new Question());
//        given(questionMapper.questionToQuestionResponseDto(Mockito.any(Question.class))).willReturn(questionResponseDto);
//
//        ResultActions actions = mockMvc.perform(
//                get("/questions/{question-id}", questionId)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//        );
//
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("get-question",
//                        getRequestPreProcessor(),
//                        getResponsePreprocessor(),
//                        pathParameters(
//                                parameterWithName("question-id").description("질문 식별자")
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("id").type(JsonFieldType.NUMBER).description("질문 식별자"),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("content").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("tag").type(JsonFieldType.STRING).description("태그"),
//                                        fieldWithPath("view").type(JsonFieldType.NUMBER).description("조회"),
//                                        fieldWithPath("vote").type(JsonFieldType.NUMBER).description("추천"),
//                                        fieldWithPath("user").type(JsonFieldType.OBJECT).description("작성자"),
//                                        fieldWithPath("user.id").type(JsonFieldType.NUMBER).description("식별자"),
//                                        fieldWithPath("user.name").type(JsonFieldType.STRING).description("이름")
//                                )
//                        )
//                ));
//    }
//
//    @Test
//    public void getQuestionsTest() throws Exception {
//        Question question1 = new Question(1L, "How to...", "I have a..", new Tag(1L, "JAVASCRIPT", "javascript is..."), 0, 0, new User(1L, "홍길동"));
//        Question question2 = new Question(2L, "Can I...", "So I am...", new Tag(2L, "JAVA", "java is..."), 0, 0, new User(2L, "이몽룡"));
//
//        Page<Question> pageQuestions = new PageImpl<>(List.of(question1, question2), PageRequest.of(0, 10), 2);
//
//        List<QuestionResponseDto> questionResponseDtos = List.of(
//                new QuestionResponseDto(1L, "How to...", "I have a..", new Tag(1L, "JAVASCRIPT", "javascript is..."), 0, 0, new User(1L, "홍길동")),
//                new QuestionResponseDto(2L, "Can I...", "So I am...", new Tag(2L, "JAVA", "java is..."), 0, 0, new User(2L, "이몽룡"))
//        );
//        int page = 1;
//        int size = 1;
//
//        given(questionService.findQuestions(Mockito.anyInt(), Mockito.anyInt())).willReturn(pageQuestions);
//        given(questionMapper.questionsToQuestionResponseDtos(Mockito.anyList())).willReturn(questionResponseDtos);
//
//        ResultActions actions = mockMvc.perform(
//                get("/questions")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .param("page", String.valueOf(page))
//                        .param("size", String.valueOf(size))
//        );
//
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("get-questions",
//                        getRequestPreProcessor(),
//                        getResponsePreprocessor(),
//                        requestParameters(
//                                parameterWithName("page").description("페이지"),
//                                parameterWithName("size").description("사이즈")
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("[].id").type(JsonFieldType.NUMBER).description("질문 식별자"),
//                                        fieldWithPath("[].title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("[].content").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("[].tag").type(JsonFieldType.STRING).description("태그"),
//                                        fieldWithPath("[].view").type(JsonFieldType.NUMBER).description("조회"),
//                                        fieldWithPath("[].vote").type(JsonFieldType.NUMBER).description("추천"),
//                                        fieldWithPath("[].user").type(JsonFieldType.OBJECT).description("작성자"),
//                                        fieldWithPath("[].user.id").type(JsonFieldType.NUMBER).description("식별자"),
//                                        fieldWithPath("[].user.name").type(JsonFieldType.STRING).description("이름")
//                                )
//                        )
//                ));
//    }
//
//    @Test
//    public void deleteQuestionTest() throws Exception {
//        long questionId = 1;
//
//        questionService.deleteQuestion(Mockito.anyLong());
//
//        ResultActions actions = mockMvc.perform(
//                delete("/questions/{question-id}", questionId)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//        );
//
//        actions
//                .andExpect(status().isNoContent())
//                .andDo(document("delete-question",
//                        getRequestPreProcessor(),
//                        getResponsePreprocessor(),
//                        pathParameters(
//                                parameterWithName("question-id").description("질문 식별자")
//                        )
//                ));
//    }
//}
