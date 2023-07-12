package com.kiledel.course.adapter.out.persistence;

import com.kiledel.annotation.PersistenceAdapter;
import com.kiledel.course.application.port.out.CreateCoursePort;
import com.kiledel.course.domain.Course;
import com.kiledel.course.domain.CourseId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
class CoursePersistenceAdapter implements CreateCoursePort {

    private final JpaCourseRepository jpaCourseRepository;
    @Override
    public CourseId create(Course course) {
        CourseEntity savedEntity = jpaCourseRepository.save(toCreateEntity(course));
        return new CourseId(savedEntity.getCourseId());
    }

    CourseEntity toCreateEntity(Course course) {
        return CourseEntity.builder()
                .courseId(course.isCreated() ? null : course.getCourseId().value())
                .title(course.getTitle())
                .contents(course.getContents())
                .state(course.getState().getCode())
                .startAt(course.getStartAt())
                .endAt(course.getEndAt())
                .presenterName(course.getPresenterName())
                .placeName(course.getPlace().name())
                .totalPlaceSeat(course.getPlace().totalSeats())
                .build();
    }
}
