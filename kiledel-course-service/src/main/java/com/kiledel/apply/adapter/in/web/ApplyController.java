package com.kiledel.apply.adapter.in.web;

import com.kiledel.apply.application.port.in.CreateApplyUseCase;
import com.kiledel.common.model.CommonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ApplyController {
    private final CreateApplyUseCase createApplyUseCase;

    @PostMapping("/courses/{courseId}/apply")
    public CommonResponse<CreateApplyResponse> create(@PathVariable Long courseId,
                                          @Valid @RequestBody CreateApplyRequest request) {
        return CommonResponse.ok(new CreateApplyResponse(createApplyUseCase.createApply(request.toCommand(courseId)).value()));
    }
}
