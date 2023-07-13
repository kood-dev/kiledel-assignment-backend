package com.kiledel.course.application;

import com.kiledel.course.application.port.in.CourseFilter;
import com.kiledel.course.application.port.out.CourseQuery;
import com.kiledel.course.application.port.out.FindCoursesPort;
import com.kiledel.course.domain.Course;
import com.kiledel.course.domain.CourseId;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseQueryServiceTest {
    @Test
    void 전체강연_목록조회() {
        // given
        Course course = Course.builder()
                .courseId(new CourseId(1L))
                .title("강연1")
                .contents("강연1 내용")
                .speaker("강연자1")
                .placeName("강연장1")
                .totalSeats(100)
                .startAt(LocalDateTime.of(2023, 7, 13, 9, 0, 0))
                .endAt(LocalDateTime.of(2023, 7, 13, 12, 0, 0))
                .build();

        CourseQueryService courseQueryService = new CourseQueryService(new FindCoursesPort() {
            @Override
            public List<Course> findCourses(CourseFilter filter) {
                return List.of(course);
            }
        });

        // when
        List<CourseQuery> courses = courseQueryService.findCourses(new CourseFilter());

        // then
        assertEquals(1, courses.size());
    }

    @Test
    void 강연조건별목록조회() {

    }
}