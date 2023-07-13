package com.kiledel.course.application.port.in;

import lombok.Builder;

import java.time.LocalDateTime;

public class CourseFilter {
    LocalDateTime startAt;
    LocalDateTime endAt;
    String speaker;

    @Builder
    public CourseFilter(LocalDateTime startAt, LocalDateTime endAt, String speaker) {
        this.startAt = startAt;
        this.endAt = endAt;
        this.speaker = speaker;
    }

    /*
    public Pageable toSpecification() {
        return null;
    }
     */
}
