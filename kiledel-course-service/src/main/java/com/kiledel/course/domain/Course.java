package com.kiledel.course.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Course {
    public static final Integer DEFAULT_SEAT_COUNT = 100;

    private CourseId courseId;
    private String title;
    private String contents;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String speaker;

    private CoursePlace place;

    @Builder
    public Course(CourseId courseId, String title, String contents,
                  LocalDateTime startAt, LocalDateTime endAt, String speaker, String placeName, int totalSeats) {
        this.courseId = courseId;
        this.title = title;
        this.contents = contents;
        this.startAt = startAt;
        this.endAt = endAt;
        this.speaker = speaker;
        this.place = new CoursePlace(placeName, totalSeats);

    }

    public boolean isCreated() {
        return courseId == null;
    }

}