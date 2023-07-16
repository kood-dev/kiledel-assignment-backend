package com.kiledel.apply.application.port.in;

import com.kiledel.apply.application.ApplyLockable;
import com.kiledel.apply.domain.Apply;
import com.kiledel.course.domain.CourseId;

public record CreateApplyCommand(Long courseId, String employeeNo) implements ApplyLockable {
    public Apply toDomain() {
        return Apply.builder()
                .employeeNo(employeeNo)
                .courseId(new CourseId(courseId))
                .build();
    }

    @Override
    public Long getCourseId() {
        return courseId;
    }

    @Override
    public String getEmployeeNo() {
        return employeeNo;
    }
}
