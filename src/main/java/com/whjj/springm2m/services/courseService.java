package com.whjj.springm2m.services;

import java.util.List;
import java.util.Optional;

import com.whjj.springm2m.models.Course;
import com.whjj.springm2m.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class courseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course insertOrUpdate(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> findById(int id) {
        return courseRepository.findById(id);
    }

    public List<Course> findAll() {
        var sort = Sort.by("title").ascending();
        return courseRepository.findAll(sort);
    }

    public boolean delete(int id) {
        courseRepository.deleteById(id);
        var course = courseRepository.findById(id);
        return course.isEmpty();
    }
}
