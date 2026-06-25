package com.hibernate.relationshipmapping.ManyToMany;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class StudentMTM {

    @Id
    private int studentId;

    private String studentName;

    @ManyToMany(cascade = CascadeType.ALL)

    @JoinTable(
            name = "student_course",

            joinColumns =
            @JoinColumn(name = "student_id"),

            inverseJoinColumns =
            @JoinColumn(name = "course_id")
    )

    private List<Course> courses;

    public StudentMTM() {
    }

    public StudentMTM(
            int studentId,
            String studentName,
            List<Course> courses) {

        this.studentId = studentId;
        this.studentName = studentName;
        this.courses = courses;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}