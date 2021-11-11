package com.whjj.springm2m.models;

import java.util.List;

public class Register {
    private int studentId;
    private List<Course> courses;

    public Register() {
    }

    public Register(int studentId, List<Course> courses) {
        this.studentId = studentId;
        this.courses = courses;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
