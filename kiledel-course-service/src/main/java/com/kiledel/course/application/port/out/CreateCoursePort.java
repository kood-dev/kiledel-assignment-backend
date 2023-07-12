package com.kiledel.course.application.port.out;

import com.kiledel.course.domain.Course;
import com.kiledel.course.domain.CourseId;

public interface CreateCoursePort {
    CourseId create(Course course);
}
