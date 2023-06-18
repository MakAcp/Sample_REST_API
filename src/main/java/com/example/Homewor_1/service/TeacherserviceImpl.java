package com.example.Homewor_1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Homewor_1.entities.Student;
import com.example.Homewor_1.entities.Teacher;
import com.example.Homewor_1.errorhandling.ResourceNotFoundException;
import com.example.Homewor_1.repository.TeacherRepository;

@Service
public class TeacherserviceImpl implements Teacherservice{

    private final TeacherRepository repository;

    @Autowired
    public TeacherserviceImpl(TeacherRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Teacher> getteachers() {
    
        return repository.findAll();
    
    }

    @Override
    public Optional<Teacher> getteacher(int l) throws ResourceNotFoundException {
    
        Optional<Teacher> teacher_get =  repository.findById(l);
        return teacher_get;

    }

    @Override
    public Teacher addteacher(Teacher teacher) {
        
        repository.save(teacher);
		return teacher;


    }

    
    
    
}
