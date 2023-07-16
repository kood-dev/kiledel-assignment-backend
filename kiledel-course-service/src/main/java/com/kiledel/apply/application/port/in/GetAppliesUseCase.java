package com.kiledel.apply.application.port.in;

import com.kiledel.apply.application.port.ApplyQuery;

import java.util.List;

public interface GetAppliesUseCase {
    List<ApplyQuery> findAppliesByEmployeeNo(String employeeNo);
}
