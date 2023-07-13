package com.kiledel.course.adapter.in.web;

import com.kiledel.common.model.CommonResponse;
import com.kiledel.course.application.port.in.CreateCourseUseCase;
import com.kiledel.course.application.port.in.GetCoursesUseCase;
import com.kiledel.course.application.port.out.CourseQuery;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CourseController {

    private final CreateCourseUseCase createCourseUseCase;
    private final GetCoursesUseCase getCoursesUseCase;

    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public CommonResponse<CreateCourseResponse> create(@Valid @RequestBody CreateCourseRequest request) {
        return CommonResponse.ok(new CreateCourseResponse(createCourseUseCase.save(request.toCommand()).value()));
    }

    @GetMapping("/courses")
    public CommonResponse<List<CourseQuery>> findCourses(CourseFilterRequest request) {
        return CommonResponse.ok(getCoursesUseCase.findCourses(request.toFilter()));
    }

}
