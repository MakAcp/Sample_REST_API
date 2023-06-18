package com.example.Homewor_1.service;

import java.util.List;
import java.util.Optional;

import com.example.Homewor_1.entities.Student;
import com.example.Homewor_1.entities.Teacher;
import com.example.Homewor_1.errorhandling.ResourceNotFoundException;

public interface Teacherservice {
    
    
    public List<Teacher> getteachers();

    public Optional<Teacher> getteacher(int l) throws ResourceNotFoundException;

    public Teacher addteacher(Teacher teacher);


}
