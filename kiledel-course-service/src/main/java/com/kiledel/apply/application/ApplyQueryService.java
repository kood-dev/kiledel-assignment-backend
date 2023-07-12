package com.kiledel.apply.application;

import com.kiledel.apply.application.port.ApplyQuery;
import com.kiledel.apply.application.port.in.FindAppliesUseCase;
import com.kiledel.apply.application.port.out.ApplyQueryPort;
import com.kiledel.apply.domain.Apply;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ApplyQueryService implements FindAppliesUseCase {
    private final ApplyQueryPort applyQueryPort;

    @Override
    public List<ApplyQuery> findAppliesByEmployeeNo(String employeeNo) {
        List<Apply> applies = applyQueryPort.findAllByEmployeeNo(employeeNo);
        return applies.stream().map(ApplyQuery::of).toList();
    }


}
