package com.kiledel.course.domain;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum CourseStatus {
    OPEN("OPEN", "접수중"),
    SOLD_OUT("SOLD_OUT", "접수 마감"),
    IN_PROGRESS("IN_PROGRESS", "진행중"),
    COMPLETED("COMPLETED", "진행완료");

    private final String code;
    private final String desc;

    CourseStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static CourseStatus findType(String code) {
        return Arrays.stream(CourseStatus.values())
                .filter(courseStatus -> courseStatus.code.equals(code))
                .findFirst()
                .orElse(CourseStatus.OPEN);
    }
}
