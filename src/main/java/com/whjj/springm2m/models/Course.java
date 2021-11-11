package com.whjj.springm2m.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 50)
    private String title;

    // Relacao m2m com student

    // @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    // private Set<Student> students = new HashSet<>();


    public Course() {
    }

    public Course(int id, String title, Set<Student> students) {
        this.id = id;
        this.title = title;
        // this.students = students;
    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // public Set<Student> getStudents() {
    //     return this.students;
    // }

    // public void setStudents(Set<Student> students) {
    //     this.students = students;
    // }

}
