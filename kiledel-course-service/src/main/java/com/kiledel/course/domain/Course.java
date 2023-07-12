package com.kiledel.course.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Course {
    private static Integer DEFAULT_SEAT_COUNT = 100;

    private CourseId courseId;
    private String title;
    private String contents;
    private CourseStatus state;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String presenterName;

    private CoursePlace place;

    @Builder
    public Course(CourseId courseId, String title, String contents, CourseStatus state, LocalDateTime startAt, LocalDateTime endAt, String presenterName, String placeName) {
        this.courseId = courseId;
        this.title = title;
        this.contents = contents;
        this.state = state;
        this.startAt = startAt;
        this.endAt = endAt;
        this.presenterName = presenterName;
        this.place = CoursePlace.builder()
                .name(placeName)
                .totalSeats(DEFAULT_SEAT_COUNT)
                .build();
    }

    public boolean isCreated() {
        return courseId == null;
    }

}