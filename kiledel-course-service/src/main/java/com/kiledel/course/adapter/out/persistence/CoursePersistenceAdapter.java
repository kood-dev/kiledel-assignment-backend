package com.kiledel.course.adapter.out.persistence;

import com.kiledel.common.annotation.PersistenceAdapter;
import com.kiledel.common.exception.ResultNotFoundException;
import com.kiledel.course.application.port.in.CourseFilter;
import com.kiledel.course.application.port.out.CreateCoursePort;
import com.kiledel.course.application.port.out.GetCoursePort;
import com.kiledel.course.application.port.out.GetCoursesPort;
import com.kiledel.course.domain.Course;
import com.kiledel.course.domain.CourseId;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
class CoursePersistenceAdapter implements CreateCoursePort, GetCoursesPort, GetCoursePort {

    private final JpaCourseRepository jpaCourseRepository;
    @Override
    public CourseId create(Course course) {
        CourseEntity savedEntity = jpaCourseRepository.save(toEntity(course));
        return new CourseId(savedEntity.getCourseId());
    }

    @Override
    public List<Course> findCourses(CourseFilter filter) {
        return jpaCourseRepository.findAll()
                .stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public Course findCourseByCourseId(CourseId courseId) {
        return jpaCourseRepository.findById(courseId.value())
                .map(this::toDomain)
                .orElseThrow(ResultNotFoundException::new);
    }

    CourseEntity toEntity(Course course) {
        return CourseEntity.builder()
                .courseId(course.isCreated() ? null : course.getCourseId().value())
                .title(course.getTitle())
                .contents(course.getContents())
                .startAt(course.getStartAt())
                .endAt(course.getEndAt())
                .speaker(course.getSpeaker())
                .placeName(course.getPlace().name())
                .totalPlaceSeat(course.getPlace().totalSeats())
                .build();
    }

    Course toDomain(CourseEntity entity) {
        return Course.builder()
                .courseId(new CourseId(entity.getCourseId()))
                .title(entity.getTitle())
                .contents(entity.getContents())
                .startAt(entity.getStartAt())
                .endAt(entity.getEndAt())
                .speaker(entity.getSpeaker())
                .placeName(entity.getPlaceName())
                .totalSeats(entity.getTotalPlaceSeat())
                .build();
    }
}
