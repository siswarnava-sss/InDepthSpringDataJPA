package com.spring.data.jpa.InDepthSpringDataJPA.repository;

import com.spring.data.jpa.InDepthSpringDataJPA.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
