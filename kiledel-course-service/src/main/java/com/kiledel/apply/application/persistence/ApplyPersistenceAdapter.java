package com.kiledel.apply.application.persistence;

import com.kiledel.common.annotation.PersistenceAdapter;
import com.kiledel.apply.application.port.out.ApplyQueryPort;
import com.kiledel.apply.domain.Apply;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
public class ApplyPersistenceAdapter implements ApplyQueryPort {
    private final JapApplyRepository applyRepository;
    @Override
    public List<Apply> findAllByEmployeeNo(final String employeeNo) {
        return applyRepository.findAllByEmployeeNo(employeeNo).stream()
                .map(this::toApply).toList();
    }

    private Apply toApply(ApplyEntity applyEntity) {
        return Apply.builder()
                .employeeNo(applyEntity.getEmployeeNo())
                .status(applyEntity.getStatus())
                .appliedAt(applyEntity.getAppliedAt())
                .build();
    }
}
