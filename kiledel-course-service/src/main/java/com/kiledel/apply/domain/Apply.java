package com.kiledel.apply.domain;

import com.kiledel.course.domain.CourseId;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class Apply {
    private ApplyId applyId;
    private CourseId courseId;
    private String employeeNo;
    private ApplyState state;
    private LocalDateTime appliedAt;
    private LocalDateTime lastModifiedAt;

    @Builder
    public Apply(ApplyId applyId, CourseId courseId, String employeeNo, ApplyState state, LocalDateTime appliedAt, LocalDateTime lastModifiedAt) {
        this.applyId = applyId;
        this.courseId = courseId;
        this.employeeNo = employeeNo;
        this.state = state;
        this.appliedAt = appliedAt;
        this.lastModifiedAt = lastModifiedAt;
    }

}
