package com.kiledel.course.application.port.in;

import com.kiledel.course.domain.Course;
import com.kiledel.course.domain.CourseStatus;
import lombok.Builder;

import java.time.LocalDateTime;

public class CreateCourseCommand {
    private String title;
    private String contents;
    private String state;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String presenterName;
    private String placeName;

    @Builder
    public CreateCourseCommand(String title, String contents, String state, LocalDateTime startAt, LocalDateTime endAt, String presenterName, String placeName) {
        this.title = title;
        this.contents = contents;
        this.state = state;
        this.startAt = startAt;
        this.endAt = endAt;
        this.presenterName = presenterName;
        this.placeName = placeName;
    }

    public Course of() {
        return Course.builder()
                .title(title)
                .contents(contents)
                .state(CourseStatus.findType(state))
                .startAt(startAt)
                .endAt(endAt)
                .presenterName(presenterName)
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
