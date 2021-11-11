package com.whjj.springm2m.controllers;

import com.whjj.springm2m.services.courseService;

import java.util.List;

import com.whjj.springm2m.models.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private courseService courseService;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Course course) {
        course = courseService.insertOrUpdate(course);
        if (course != null) {
            return new ResponseEntity<>("Curso cadastrado com sucesso", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Curso não cadastrado", HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Course> findAll() {
        return courseService.findAll();
    }

}
