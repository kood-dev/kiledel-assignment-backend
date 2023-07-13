package com.kiledel.course.application.port.in;

import com.kiledel.course.application.port.out.CourseQuery;

import java.util.List;

public interface GetCoursesUseCase {
    List<CourseQuery> findCourses(CourseFilter query);
}
