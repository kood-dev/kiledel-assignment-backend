package com.kiledel.course.adapter.in.web;

import com.kiledel.course.application.port.in.CreateCourseUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CourseController {

    private final CreateCourseUseCase createCourseUseCase;

    @PostMapping("/course")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CreateCourseResponse> create(@Valid @RequestBody CreateCourseRequest request) {
        return ResponseEntity.ok(new CreateCourseResponse(createCourseUseCase.save(request.toCommand()).value()));
    }
}
