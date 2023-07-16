package com.kiledel.apply.application.port;

import com.kiledel.apply.domain.Apply;

import java.time.LocalDateTime;

public record ApplyQuery(String employeeNo, String state, LocalDateTime appliedAt) {
    public static ApplyQuery of(Apply apply) {
        return new ApplyQuery(apply.getEmployeeNo(), apply.getState().name(), apply.getAppliedAt());
    }
}
