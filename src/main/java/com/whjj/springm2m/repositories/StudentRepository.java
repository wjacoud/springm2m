package com.whjj.springm2m.repositories;

import java.util.List;

import com.whjj.springm2m.models.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findByNameContaining(String name);
}
