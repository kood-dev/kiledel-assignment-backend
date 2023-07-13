package com.kiledel.course.application.port.out;

import com.kiledel.course.application.port.in.CourseFilter;
import com.kiledel.course.domain.Course;

import java.util.List;

public interface FindCoursesPort {
    List<Course> findCourses(CourseFilter filter);

}
