package com.kiledel.course.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseTest {

    @Test
    void 강연_지원가능_체크() {
        int fewDayAgo = 7;

        Course course = Course.builder()
                .courseId(new CourseId(1L))
                .title("강연1")
                .contents("강연1 내용")
                .speaker("강연자1")
                .placeName("강연장1")
                .totalSeats(100)
                .startAt(LocalDateTime.of(2023, 7, 13, 9, 0, 0))
                .endAt(LocalDateTime.of(2023, 7, 13, 12, 0, 0))
                .build();

        LocalDateTime possibleDate = LocalDateTime.of(2023, 7, 6, 8, 30, 0);
        LocalDateTime not7DayAgo = LocalDateTime.of(2023, 7, 5, 8, 30, 0);
        LocalDateTime overDay = LocalDateTime.of(2023, 7, 13, 10, 30, 0);

        // 시작 7일전부터 강연시작시간까지
        assertTrue(course.isOpened(possibleDate, fewDayAgo));
        assertFalse(course.isOpened(not7DayAgo, fewDayAgo));
        assertFalse(course.isOpened(overDay, fewDayAgo));
    }

    @Test
    void 강연_외부노출_조회() {
        int fewDayAgo = 7;
        int fewDayLater = 1;

        Course course = Course.builder()
                .courseId(new CourseId(1L))
                .title("강연1")
                .contents("강연1 내용")
                .speaker("강연자1")
                .placeName("강연장1")
                .totalSeats(100)
                .startAt(LocalDateTime.of(2023, 7, 13, 9, 0, 0))
                .endAt(LocalDateTime.of(2023, 7, 13, 12, 0, 0))
                .build();

        // 7일 전
        LocalDateTime openingDate = LocalDateTime.of(2023, 7, 6, 8, 30, 0);
        // 8일 전
        LocalDateTime notOpeningDate = LocalDateTime.of(2023, 7, 5, 8, 30, 0);
        // 1일 후
        LocalDateTime later1Day = LocalDateTime.of(2023, 7, 14, 9, 0, 0);
        // 2일 후
        LocalDateTime later2Day = LocalDateTime.of(2023, 7, 15, 9, 0, 0);


        assertTrue(course.isVisible(openingDate, fewDayAgo, fewDayLater));
        assertTrue(course.isVisible(later1Day, fewDayAgo, fewDayLater));

        assertFalse(course.isVisible(notOpeningDate, fewDayAgo, fewDayLater));
        assertFalse(course.isVisible(later2Day, fewDayAgo, fewDayLater));

    }
}