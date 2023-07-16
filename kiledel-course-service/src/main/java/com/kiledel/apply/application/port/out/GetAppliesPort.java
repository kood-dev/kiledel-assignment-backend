package com.kiledel.apply.application.port.out;

import com.kiledel.apply.domain.Apply;

import java.util.List;

public interface GetAppliesPort {

    List<Apply> findAllByEmployeeNo(String employeeNo);
}
