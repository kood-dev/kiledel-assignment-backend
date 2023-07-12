package com.kiledel.course.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCourseRepository extends JpaRepository<CourseEntity, Long> {
}
