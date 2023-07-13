package com.kiledel.course.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class Course {
    public static final int DAYS_AGO = 7;
    public static final int DAYS_LATER = 1;

    private CourseId courseId;
    private String title;
    private String contents;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String speaker;

    private CoursePlace place;

    @Builder
    public Course(CourseId courseId, String title, String contents,
                  LocalDateTime startAt, LocalDateTime endAt, String speaker, String placeName, int totalSeats) {
        this.courseId = courseId;
        this.title = title;
        this.contents = contents;
        this.startAt = startAt;
        this.endAt = endAt;
        this.speaker = speaker;
        this.place = new CoursePlace(placeName, totalSeats);

    }

    public boolean isCreated() {
        return courseId == null;
    }

    public boolean isOpened(LocalDateTime now, int fewDaysAgo) {
        LocalDateTime openingDate = startAt.toLocalDate().minusDays(fewDaysAgo).atStartOfDay();
        LocalDateTime closingDate = startAt;
        return isDateTimeBetween(now, openingDate, closingDate);
    }

    /**
     * 강연 외부 노출 체크
     * @param now
     * @param fewDaysAgo
     * @param fewDaysLater
     * @return
     */
    public boolean isVisible(LocalDateTime now, int fewDaysAgo, int fewDaysLater) {
        LocalDateTime openingDate = startAt.toLocalDate().minusDays(fewDaysAgo).atStartOfDay();
        LocalDateTime closingDate = endAt.plusDays(fewDaysLater);
        return isDateTimeBetween(now, openingDate, closingDate);
    }

    private boolean isDateTimeBetween(LocalDateTime now, LocalDateTime start, LocalDateTime end) {
        return now.isAfter(start) && now.isBefore(end);
    }

}