package com.kiledel.course.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Indexed;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "courses", indexes = {
        @Index(name = "idx_courses_start_at_end_at", columnList = "startAt, endAt")
})
class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String title;
    private String contents;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startAt;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endAt;
    private String speaker;

    private String placeName;
    private Integer totalPlaceSeat;

    @Builder
    public CourseEntity(Long courseId, String title, String contents, LocalDateTime startAt, LocalDateTime endAt,
                        String speaker, String placeName, Integer totalPlaceSeat) {
        this.courseId = courseId;
        this.title = title;
        this.contents = contents;
        this.startAt = startAt;
        this.endAt = endAt;
        this.speaker = speaker;
        this.placeName = placeName;
        this.totalPlaceSeat = totalPlaceSeat;
    }
}