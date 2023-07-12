package com.kiledel.apply.application.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JapApplyRepository extends JpaRepository<ApplyEntity, Long> {
    List<ApplyEntity> findAllByEmployeeNo(String employeeNo);
}
