package com.whjj.springm2m.services;

import java.util.List;
import java.util.Optional;

import com.whjj.springm2m.models.Student;
import com.whjj.springm2m.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student insertOrUpdate(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> findById(int id) {
        return studentRepository.findById(id);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public boolean delete(int id) {
        studentRepository.deleteById(id);
        var student = studentRepository.findById(id);
        return student.isEmpty();
    }
}
