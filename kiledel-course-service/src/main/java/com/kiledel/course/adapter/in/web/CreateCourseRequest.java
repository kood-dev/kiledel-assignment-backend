package com.kiledel.course.adapter.in.web;

import com.kiledel.course.application.port.in.CreateCourseCommand;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
class CreateCourseRequest {
    private String title;
    private String contents;
    private String status;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String speaker;
    private String placeName;
    public CreateCourseCommand toCommand() {
        return CreateCourseCommand.builder()
                .title(title)
                .contents(contents)
                .status(status)
                .startAt(startAt)
                .endAt(endAt)
                .speaker(speaker)
                .placeName(placeName)
                .build();
    }
/* TODO 고민.
    class CreateCoursePlaceRequest {
        String place;
        int totalSeat;
    }*/
}
