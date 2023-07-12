package com.kiledel.apply.application;

import com.kiledel.apply.application.port.ApplyQuery;
import com.kiledel.apply.domain.Apply;
import com.kiledel.apply.domain.ApplyStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplyQueryServiceTest {

    @Test
    void 신청한강연_목록조회() {
        String employeeNo = "123456";

        Apply apply = Apply.builder()
                .employeeNo(employeeNo)
                .status(ApplyStatus.APPLIED)
                .build();
        List<Apply> applies = List.of(apply);

        ApplyQueryService applyQueryService = new ApplyQueryService(employeeNo1 -> applies);

        List<ApplyQuery> response = applyQueryService.findAppliesByEmployeeNo(employeeNo);

        // 조회 확인
        assertThat(response).isNotEmpty();
    }

//    @Test
//    void 강연신청() {
//        /*
//            제약사항
//            - 시작 이후는 신청할 수 없다.
//            - 신청은 1회만 가능하다.
//            - 신청은 강연시작 1주일 전 까지 가능하다.
//         */
//
//
//        CreateCourseApplyRequest response = applyQueryService.requestApply();
//        // 신청 확인
//        assertThat(response).isNotNull();
//    }
//
//    private class CreateCourseApplyRequest {
//    }


}
