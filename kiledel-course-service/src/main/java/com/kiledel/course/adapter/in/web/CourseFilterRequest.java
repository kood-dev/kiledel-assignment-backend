package com.kiledel.course.adapter.in.web;

import com.kiledel.course.application.port.in.CourseFilter;

import java.time.LocalDateTime;

class CourseFilterRequest {
    LocalDateTime startAt;
    LocalDateTime endAt;
    String speaker;

    public CourseFilter toFilter() {
        return CourseFilter.builder()
                .startAt(startAt)
                .endAt(endAt)
                .speaker(speaker)
                .build();
    }
}
