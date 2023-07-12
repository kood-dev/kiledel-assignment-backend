package com.kiledel.apply.application.persistence;

import com.kiledel.apply.domain.ApplyStatus;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "course_apply")
class ApplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String employeeNo;
    private ApplyStatus status;
    private LocalDateTime appliedAt;
}
