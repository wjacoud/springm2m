package com.whjj.springm2m.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(columnDefinition = "tinyint(2) not null")
    private byte age;
    @Column(nullable = false, length = 100)
    private String grade;

    // Relation Student m2m courses
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "students_courses", joinColumns = {
        @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false, updatable=false)},
        inverseJoinColumns = {
            @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false, updatable=false)})
    private Set<Course> courses = new HashSet<>();


    public Student() {
    }

    public Student(int id, String name, byte age, String grade, Set<Course> courses) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.courses = courses;
    }

    public Student(String name, byte age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return this.age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getGrade() {
        return this.grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Set<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

}
