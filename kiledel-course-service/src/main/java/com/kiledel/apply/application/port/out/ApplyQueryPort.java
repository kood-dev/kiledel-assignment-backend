package com.kiledel.apply.application.port.out;

import com.kiledel.apply.domain.Apply;

import java.util.List;

public interface ApplyQueryPort {

    List<Apply> findAllByEmployeeNo(String employeeNo);
}
