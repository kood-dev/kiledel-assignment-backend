package com.kiledel.apply.application.port.in;

import com.kiledel.apply.domain.ApplyId;

public interface CreateApplyUseCase {
    ApplyId createApply(CreateApplyCommand command);
}
