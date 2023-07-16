package com.kiledel.apply.application;

import com.kiledel.apply.application.port.ApplyQuery;
import com.kiledel.apply.application.port.in.GetAppliesUseCase;
import com.kiledel.apply.application.port.out.GetAppliesPort;
import com.kiledel.apply.domain.Apply;
import com.kiledel.common.annotation.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@UseCase
public class ApplyQueryService implements GetAppliesUseCase {
    private final GetAppliesPort getAppliesPort;

    @Override
    public List<ApplyQuery> findAppliesByEmployeeNo(String employeeNo) {
        List<Apply> applies = getAppliesPort.findAllByEmployeeNo(employeeNo);
        return applies.stream().map(ApplyQuery::of).toList();
    }


}
