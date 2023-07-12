package com.kiledel.apply.application.port.in;

import com.kiledel.apply.application.port.ApplyQuery;

import java.util.List;

public interface FindAppliesUseCase {
    List<ApplyQuery> findAppliesByEmployeeNo(String employeeNo);
}
