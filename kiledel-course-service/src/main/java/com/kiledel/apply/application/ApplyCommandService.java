package com.kiledel.apply.application;

import com.kiledel.apply.application.port.in.CreateApplyCommand;
import com.kiledel.apply.application.port.in.CreateApplyUseCase;
import com.kiledel.apply.application.port.out.CreateApplyPort;
import com.kiledel.apply.domain.ApplyId;
import com.kiledel.common.annotation.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
@UseCase
public class ApplyCommandService implements CreateApplyUseCase {

    private final CreateApplyPort createApplyPort;

    @ApplyLock
    @Override
    public ApplyId createApply(CreateApplyCommand command) {
        // TODO add validate, seat course & duplicate apply
        ApplyId applyId = createApplyPort.createApply(command.toDomain());
        return applyId;
    }
}
