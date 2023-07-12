package com.kiledel.course.application.port.out;

import com.kiledel.course.domain.Course;
import com.kiledel.course.domain.CourseId;
import lombok.Builder;

import java.time.LocalDateTime;

public class CourseQuery {
    private CourseId courseId;
    private String title;
    private String contents;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String speaker;

    private CoursePlaceQuery place;

    @Builder
    public CourseQuery(CourseId courseId, String title, String contents, LocalDateTime startAt, LocalDateTime endAt, String speaker, CoursePlaceQuery place) {
        this.courseId = courseId;
        this.title = title;
        this.contents = contents;
        this.startAt = startAt;
        this.endAt = endAt;
        this.speaker = speaker;
        this.place = place;
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
