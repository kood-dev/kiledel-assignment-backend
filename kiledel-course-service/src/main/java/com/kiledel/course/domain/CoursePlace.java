package com.kiledel.course.domain;

import lombok.Builder;

public record CoursePlace(String name, int totalSeats) {
    @Builder
    public CoursePlace {
    }
}
