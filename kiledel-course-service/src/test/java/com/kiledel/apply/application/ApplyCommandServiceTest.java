package com.kiledel.apply.application;

import com.kiledel.apply.application.port.out.CreateApplyPort;
import com.kiledel.apply.domain.Apply;
import com.kiledel.apply.domain.ApplyId;
import com.kiledel.course.domain.CourseId;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

//@Disabled
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ApplyCommandServiceTest {

    @Autowired
    private CreateApplyPort createApplyPort;
    @Test
    void createApply() {
        String employeeNo = "K1234";

        Apply apply = Apply.builder()
                .courseId(new CourseId(1L))
                .employeeNo(employeeNo)
                .build();
        ApplyId applyId = createApplyPort.createApply(apply);

        assertThat(applyId.value()).isEqualTo(1L);

    }
}