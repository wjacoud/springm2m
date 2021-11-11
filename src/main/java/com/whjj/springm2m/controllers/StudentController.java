package com.whjj.springm2m.controllers;

import java.util.List;

import com.whjj.springm2m.models.Register;
import com.whjj.springm2m.models.Student;
import com.whjj.springm2m.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    public StudentService studentService;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Student student) {
        student = studentService.insertOrUpdate(student);
        if (student != null) {
            return new ResponseEntity<String>("Estudante cadastrado com sucesso", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Estudante não cadastrado", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(@RequestBody Register register) {
        var result = studentService.findById(register.getStudentId());
        if (result.isPresent()) {
            var student = result.get();
            student.getCourses().addAll(register.getCourses());
            studentService.insertOrUpdate(student);
            return new ResponseEntity<>("Estudante matriculado com sucesso", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Estudante não localizado", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Student student) {
        student = studentService.insertOrUpdate(student);
        if (student != null) {
            return new ResponseEntity<String>("Estudante atualizado com sucesso", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Estudante não atualizado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable int id) {
        var student = studentService.findById(id);
        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        if (studentService.delete(id)) {
            return new ResponseEntity<>("Estudante Removido com sucesso", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Estudante não removido", HttpStatus.NOT_FOUND);
        }
    }
}
