package com.kiledel.apply.adapter.out.persistence;

import com.kiledel.apply.domain.ApplyState;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "course_apply")
class ApplyCourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String employeeNo;
    private ApplyState state;

    @CreatedDate
    private LocalDateTime createAt;

    @LastModifiedDate
    private LocalDateTime lastModifiedAt;

    @Version
    private Integer lastModifiedVersion;

    @Builder
    public ApplyCourseEntity(Long id, String employeeNo, ApplyState state, LocalDateTime createAt, LocalDateTime lastModifiedAt, Integer lastModifiedVersion) {
        this.id = id;
        this.employeeNo = employeeNo;
        this.state = state;
        this.createAt = createAt;
        this.lastModifiedAt = lastModifiedAt;
        this.lastModifiedVersion = lastModifiedVersion;
    }
}
