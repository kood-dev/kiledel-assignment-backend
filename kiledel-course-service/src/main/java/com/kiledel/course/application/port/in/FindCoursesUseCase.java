package com.kiledel.course.application.port.in;

import com.kiledel.course.application.port.out.CourseQuery;

import java.util.List;

public interface FindCoursesUseCase {
    List<CourseQuery> findCourses(CourseFilter query);
}
