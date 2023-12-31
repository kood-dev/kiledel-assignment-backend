package com.kiledel.course.application;

import com.kiledel.course.application.port.in.CourseFilter;
import com.kiledel.course.application.port.in.CreateCourseCommand;
import com.kiledel.course.application.port.out.CourseQuery;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CourseQueryServiceTest {
    @Autowired
    CourseCommandService courseCommandService;
    @Autowired
    CourseQueryService courseQueryService;

    @Test
    void 전체강연_목록조회() {
        // given
        CreateCourseCommand createCourseCommand = CreateCourseCommand.builder()
                .title("강연1")
                .contents("강연1 내용")
                .speaker("강연자1")
                .placeName("강연장1")
                .totalSeats(100)
                .startAt(LocalDateTime.of(2023, 7, 13, 9, 0, 0))
                .endAt(LocalDateTime.of(2023, 7, 13, 12, 0, 0))
                .build();

        // when
        courseCommandService.save(createCourseCommand);
        List<CourseQuery> courses = courseQueryService.findCourses(CourseFilter.builder().build());

        // then
        assertThat(courses.size()).isEqualTo(1L);
    }

    @Test
    void 강연조건별목록조회() {

    }
}