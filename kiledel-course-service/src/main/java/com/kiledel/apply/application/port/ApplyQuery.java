package com.kiledel.apply.application.port;

import com.kiledel.apply.domain.Apply;

import java.time.LocalDateTime;

public record ApplyQuery(String employeeNo, String status, LocalDateTime appliedAt) {
    public static ApplyQuery of(Apply apply) {
        return new ApplyQuery(apply.getEmployeeNo(), apply.getStatus().name(), apply.getAppliedAt());
    }
}
