package com.kiledel.course.application;

import com.kiledel.common.annotation.UseCase;
import com.kiledel.course.application.port.in.CourseFilter;
import com.kiledel.course.application.port.in.FindCoursesUseCase;
import com.kiledel.course.application.port.out.CourseQuery;
import com.kiledel.course.application.port.out.FindCoursesPort;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@UseCase
public class CourseQueryService implements FindCoursesUseCase {
    private final FindCoursesPort findCoursesPort;

    @Cacheable(cacheNames = "codeCache", key = "{#root.methodName, #filter}")
    @Override
    public List<CourseQuery> findCourses(CourseFilter filter) {
        return findCoursesPort.findCourses(filter)
                .stream()
                .map(CourseQuery::of)
                .toList();
    }

}
