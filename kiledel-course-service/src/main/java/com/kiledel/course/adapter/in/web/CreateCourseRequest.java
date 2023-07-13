package com.kiledel.course.adapter.in.web;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kiledel.course.application.port.in.CreateCourseCommand;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
class CreateCourseRequest {
    @NotBlank
    @Size(max = 100)
    private String title;
    @Size(max = 1000)
    private String contents;

    @Future
    private LocalDateTime startAt;
    @Future
    private LocalDateTime endAt;

    @NotBlank
    @Size(max = 50)
    private String speaker;
    @NotBlank
    @Size(max = 100)
    private String placeName;
    @Positive
    private int totalSeat;

    @Builder
    public CreateCourseRequest(String title, String contents, LocalDateTime startAt, LocalDateTime endAt, String speaker, String placeName, int totalSeat) {
        this.title = title;
        this.contents = contents;
        this.startAt = startAt;
        this.endAt = endAt;
        this.speaker = speaker;
        this.placeName = placeName;
        this.totalSeat = totalSeat;
    }

    public CreateCourseCommand toCommand() {
        return CreateCourseCommand.builder()
                .title(title)
                .contents(contents)
                .startAt(startAt)
                .endAt(endAt)
                .speaker(speaker)
                .placeName(placeName)
                .totalSeats(totalSeat)
                .build();
    }
}
