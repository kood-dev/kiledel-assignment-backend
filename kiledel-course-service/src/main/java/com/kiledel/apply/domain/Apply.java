package com.kiledel.apply.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class Apply {
    private String employeeNo;
    private ApplyStatus status;
    private LocalDateTime appliedAt;

    @Builder
    public Apply(String employeeNo, ApplyStatus status, LocalDateTime appliedAt) {
        this.employeeNo = employeeNo;
        this.status = status;
        this.appliedAt = appliedAt;
    }
}
