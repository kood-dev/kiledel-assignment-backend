package com.kiledel.course.application.port.in;

import com.kiledel.course.domain.CourseId;

public interface CreateCourseUseCase {

    CourseId save(CreateCourseCommand createCourseCommand);
}
