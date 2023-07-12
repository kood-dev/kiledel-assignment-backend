package com.kiledel.course.application;

import com.kiledel.common.annotation.UseCase;
import com.kiledel.course.application.port.in.CourseFilter;
import com.kiledel.course.application.port.in.FindCoursesUseCase;
import com.kiledel.course.application.port.out.CourseQuery;
import com.kiledel.course.application.port.out.FindCoursesPort;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@RequiredArgsConstructor
@UseCase
public class CourseQueryService implements FindCoursesUseCase {
    private final FindCoursesPort findCoursesPort;

    //TODO 전체 리스트와 조회 항목이 있는 리스트로 나뉘어 지기 때문에 캐시를 어떻게 적용해야 할지 고민해야 함
    @Cacheable(cacheNames = "codeCache", key = "{#root.methodName}")
    @Override
    public List<CourseQuery> findCourses(CourseFilter query) {
        return findCoursesPort.findCourses(query)
                .stream()
                .map(CourseQuery::of)
                .toList();
    }

}
