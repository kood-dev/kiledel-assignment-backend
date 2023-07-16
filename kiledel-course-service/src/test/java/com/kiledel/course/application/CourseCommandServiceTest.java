package com.kiledel.course.application;

import com.kiledel.course.application.port.in.CreateCourseCommand;
import com.kiledel.course.application.port.out.GetCoursePort;
import com.kiledel.course.domain.Course;
import com.kiledel.course.domain.CourseId;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CourseCommandServiceTest {
    @Autowired
    CourseCommandService courseCommandService;
    @Autowired
    GetCoursePort getCoursePort;

    @Test
    void save() {
        CreateCourseCommand createCourseCommand = CreateCourseCommand.builder()
                .title("강연1")
                .contents("강연1 내용")
                .speaker("강연자1")
                .placeName("강연장1")
                .totalSeats(100)
                .startAt(LocalDateTime.of(2023, 7, 13, 9, 0, 0))
                .endAt(LocalDateTime.of(2023, 7, 13, 12, 0, 0))
                .build();

        CourseId courseId = courseCommandService.save(createCourseCommand);
        Course courses = getCoursePort.findCourseByCourseId(courseId);

        assertThat(courses.getCourseId().value()).isEqualTo(courseId.value());
    }

}