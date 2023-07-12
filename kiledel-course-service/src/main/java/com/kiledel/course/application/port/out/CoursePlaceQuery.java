package com.kiledel.course.application.port.out;

import com.kiledel.course.domain.CoursePlace;
import lombok.Builder;

class CoursePlaceQuery {
    private String name;
    private Integer totalSeats;

    @Builder
    public CoursePlaceQuery(String name, Integer totalSeats) {
        this.name = name;
        this.totalSeats = totalSeats;
    }

    public static CoursePlaceQuery of(CoursePlace place) {
        return CoursePlaceQuery.builder()
                .name(place.name())
                .totalSeats(place.totalSeats())
                .build();
    }
}
