package com.kiledel.course.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "courses")
class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String title;
    private String contents;
    private String state;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startAt;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endAt;
    private String presenterName;

    private String placeName;
    private Integer totalPlaceSeat;

    @Builder
    public CourseEntity(Long courseId, String title, String contents, String state, LocalDateTime startAt, LocalDateTime endAt, String presenterName, String placeName, Integer totalPlaceSeat) {
        this.courseId = courseId;
        this.title = title;
        this.contents = contents;
        this.state = state;
        this.startAt = startAt;
        this.endAt = endAt;
        this.presenterName = presenterName;
        this.placeName = placeName;
        this.totalPlaceSeat = totalPlaceSeat;
    }
}