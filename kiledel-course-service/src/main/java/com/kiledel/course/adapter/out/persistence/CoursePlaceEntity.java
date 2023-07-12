package com.kiledel.course.adapter.out.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "course_places")
class CoursePlaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long courseId;

    private String title;
    private Integer totalSeats;
}
