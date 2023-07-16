package com.kiledel.apply.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JapApplyRepository extends JpaRepository<ApplyCourseEntity, Long> {
    List<ApplyCourseEntity> findAllByEmployeeNo(String employeeNo);
}
