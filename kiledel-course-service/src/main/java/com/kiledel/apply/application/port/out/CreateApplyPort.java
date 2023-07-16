package com.kiledel.apply.application.port.out;

import com.kiledel.apply.domain.Apply;
import com.kiledel.apply.domain.ApplyId;

public interface CreateApplyPort {
    ApplyId createApply(Apply apply);
}
