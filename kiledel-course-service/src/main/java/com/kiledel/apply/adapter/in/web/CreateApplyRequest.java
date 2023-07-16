package com.kiledel.apply.adapter.in.web;

import com.kiledel.apply.application.port.in.CreateApplyCommand;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
class CreateApplyRequest {
    @NotBlank
    private String employeeNo;

    public CreateApplyCommand toCommand(Long courseId) {
        return new CreateApplyCommand(courseId, this.employeeNo);
    }
}
