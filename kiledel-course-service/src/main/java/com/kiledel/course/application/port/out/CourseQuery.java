package com.kiledel.course.application.port.out;

import com.kiledel.course.domain.Course;
import com.kiledel.course.domain.CourseId;
import lombok.Builder;

import java.time.LocalDateTime;

public record CourseQuery(CourseId courseId, String title, String contents, LocalDateTime startAt, LocalDateTime endAt,
                          String speaker, CoursePlaceQuery place) {
    @Builder
    public CourseQuery {
    }

    public static CourseQuery of(Course course) {
        return CourseQuery.builder()
                .courseId(course.getCourseId())
                .title(course.getTitle())
                .contents(course.getContents())
                .startAt(course.getStartAt())
                .endAt(course.getEndAt())
                .speaker(course.getSpeaker())
                .place(CoursePlaceQuery.of(course.getPlace()))
                .build();
    }
}
