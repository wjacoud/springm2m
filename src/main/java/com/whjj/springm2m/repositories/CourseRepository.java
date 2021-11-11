package com.whjj.springm2m.repositories;

import java.util.List;

import com.whjj.springm2m.models.Course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByTitleContaining(String title);
}
