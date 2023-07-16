package com.kiledel.course.application.port.in;

import com.kiledel.course.domain.Course;
import lombok.Builder;

import java.time.LocalDateTime;

public class CreateCourseCommand {
    private final String title;
    private final String contents;
    private final LocalDateTime startAt;
    private final LocalDateTime endAt;
    private final String speaker;
    private final String placeName;
    private final int totalSeats;

    @Builder
    public CreateCourseCommand(String title, String contents, LocalDateTime startAt, LocalDateTime endAt, String speaker, String placeName, int totalSeats) {
        this.title = title;
        this.contents = contents;
        this.startAt = startAt;
        this.endAt = endAt;
        this.speaker = speaker;
        this.placeName = placeName;
        this.totalSeats = totalSeats;
    }

    public Course toDomain() {
        return Course.builder()
                .title(title)
                .contents(contents)
                .startAt(startAt)
                .endAt(endAt)
                .speaker(speaker)
                .placeName(placeName)
                .totalSeats(totalSeats)
                .build();
    }

}
