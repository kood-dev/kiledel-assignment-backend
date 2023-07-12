package com.kiledel.course.application;


import com.kiledel.annotation.UseCase;
import com.kiledel.course.application.port.in.CreateCourseUseCase;
import com.kiledel.course.application.port.in.CreateCourseCommand;
import com.kiledel.course.application.port.out.CreateCoursePort;
import com.kiledel.course.domain.CourseId;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
class CourseCommandService implements CreateCourseUseCase {

    private final CreateCoursePort createCoursePort;
    @Override
    public CourseId save(CreateCourseCommand command) {
        return createCoursePort.create(command.of());
    }
}

