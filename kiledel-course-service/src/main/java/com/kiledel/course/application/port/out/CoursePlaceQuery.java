package com.kiledel.course.application.port.out;

import com.kiledel.course.domain.CoursePlace;

public record CoursePlaceQuery(String name, Integer totalSeats) {

    public static CoursePlaceQuery of(CoursePlace place) {
        return new CoursePlaceQuery(place.name(), place.totalSeats());
    }
}
