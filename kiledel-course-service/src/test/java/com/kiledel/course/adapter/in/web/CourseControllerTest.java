package com.kiledel.course.adapter.in.web;

import com.kiledel.AbstractControllerTest;
import com.kiledel.course.application.port.in.CreateCourseUseCase;
import com.kiledel.course.application.port.in.GetCoursesUseCase;
import com.kiledel.course.domain.CourseId;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CourseController.class)
class CourseControllerTest extends AbstractControllerTest {

    @MockBean
    private CreateCourseUseCase createCourseUseCase;
    @MockBean
    private GetCoursesUseCase getCoursesUseCase;

    @Test
    void create() throws Exception {
        String documentPath = "courses/create";
        String url = "/courses";

        CourseId courseId = new CourseId(1L);
        CreateCourseRequest request = CreateCourseRequest.builder()
                .title("강연1")
                .contents("강연1 내용")
                .speaker("강연자1")
                .placeName("강연장1")
                .totalSeat(100)
                .startAt(LocalDateTime.now().plusDays(5))
                .endAt(LocalDateTime.now().plusDays(5).plusHours(2))
                .build();

        Mockito.when(createCourseUseCase.save(Mockito.any())).thenReturn(courseId);
        ResultActions resultActions = mockMvc.perform(post(url)
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isCreated())
                .andDo(MockMvcRestDocumentation.document(documentPath,
                        getDocumentRequest(),
                        getDocumentResponse(),
                        PayloadDocumentation.requestFields(
                                fieldWithPath("title").type(JsonFieldType.STRING).description("강연 제목"),
                                fieldWithPath("contents").type(JsonFieldType.STRING).description("강연 내용"),
                                fieldWithPath("startAt").type(JsonFieldType.STRING).description("시작 일시"),
                                fieldWithPath("endAt").type(JsonFieldType.STRING).description("종료 일시"),
                                fieldWithPath("speaker").type(JsonFieldType.STRING).description("강연자"),
                                fieldWithPath("placeName").type(JsonFieldType.STRING).description("장소명"),
                                fieldWithPath("totalSeat").type(JsonFieldType.NUMBER).description("강연장 좌석 수")
                        ),
                        commonResponseFields(false,
                                PayloadDocumentation.fieldWithPath("courseId").type(JsonFieldType.NUMBER).description("등록된 강연 ID")
                        )
                )).andDo(print());
    }

    @Test
    void findCourses() {
    }
}