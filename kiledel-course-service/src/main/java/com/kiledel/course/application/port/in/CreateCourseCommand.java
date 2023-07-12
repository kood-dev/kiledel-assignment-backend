package com.kiledel.course.application.port.in;

import com.kiledel.course.domain.Course;
import lombok.Builder;

import java.time.LocalDateTime;

public class CreateCourseCommand {
    private String title;
    private String contents;
    private String status;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String speaker;
    private String placeName;

    @Builder
    public CreateCourseCommand(String title, String contents, String status, LocalDateTime startAt, LocalDateTime endAt, String speaker, String placeName) {
        this.title = title;
        this.contents = contents;
        this.status = status;
        this.startAt = startAt;
        this.endAt = endAt;
        this.speaker = speaker;
        this.placeName = placeName;
    }

    public Course of() {
        return Course.builder()
                .title(title)
                .contents(contents)
                .startAt(startAt)
                .endAt(endAt)
                .speaker(speaker)
                .placeName(placeName)
                .build();
    }

    /*class CreateCoursePlaceCommand {
        String name;
        int totalSeat;

        public CreateCoursePlaceCommand(String name, int totalSeat) {
            this.name = name;
            this.totalSeat = totalSeat;
        }
    }
*/
}
