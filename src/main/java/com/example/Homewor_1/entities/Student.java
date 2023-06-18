package com.example.Homewor_1.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;



@Entity
@Table(name="student")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column
    private String name;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY , cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Teacher_Student> teacher_students = new ArrayList<>();

    public List<Teacher_Student> getTeacher_students() {
        return this.teacher_students;
    }

    public void setTeacher_students(List<Teacher_Student> teacher_students) {
        this.teacher_students = teacher_students;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
