package com.kiledel.apply.adapter.out.persistence;

import com.kiledel.apply.application.port.out.CreateApplyPort;
import com.kiledel.apply.domain.ApplyId;
import com.kiledel.apply.application.port.out.GetAppliesPort;
import com.kiledel.apply.domain.Apply;
import com.kiledel.common.annotation.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
public class ApplyPersistenceAdapter implements GetAppliesPort, CreateApplyPort {
    private final JapApplyRepository applyRepository;
    @Override
    public List<Apply> findAllByEmployeeNo(final String employeeNo) {
        return applyRepository.findAllByEmployeeNo(employeeNo).stream()
                .map(this::toApply).toList();
    }

    @Override
    public ApplyId createApply(Apply apply) {
        ApplyCourseEntity applyCourseEntity = ApplyCourseEntity.builder()
                .employeeNo(apply.getEmployeeNo())
                .state(apply.getState())
                .createAt(apply.getAppliedAt())
                .build();

        return new ApplyId(applyRepository.save(applyCourseEntity).getId());
    }

    private Apply toApply(ApplyCourseEntity applyCourseEntity) {
        return Apply.builder()
                .employeeNo(applyCourseEntity.getEmployeeNo())
                .state(applyCourseEntity.getState())
                .appliedAt(applyCourseEntity.getCreateAt())
                .build();
    }


}
