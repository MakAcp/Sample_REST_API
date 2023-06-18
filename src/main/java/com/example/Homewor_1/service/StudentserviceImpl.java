package com.example.Homewor_1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Homewor_1.entities.Student;
import com.example.Homewor_1.errorhandling.ResourceNotFoundException;
import com.example.Homewor_1.repository.StudentRepository;

@Service
public class StudentserviceImpl implements Studentservice{

    private final StudentRepository repository;

    @Autowired
    public StudentserviceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getstudents() {
        return repository.findAll();
    }

    @Override
    public Optional<Student> getstudent(int l) {
        Optional<Student> student_get =  repository.findById(l);
        return student_get;
    }

    @Override
    public Student addstudent(Student student) {
        repository.save(student);
		return student;
    }

    @Override
    public void delstudent(int l) {
        repository.deleteById(l);
    }

    @Override
    public Student updatestudent(int i,Student student) throws ResourceNotFoundException{

        Student student_updated = repository.findById(i).orElseThrow(() -> new ResourceNotFoundException());
        student_updated.setName(student.getName());
        return repository.save(student_updated);
    
    }
    
}
