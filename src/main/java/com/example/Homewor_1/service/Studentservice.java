package com.example.Homewor_1.service;

import java.util.List;
import java.util.Optional;

import com.example.Homewor_1.entities.Student;
import com.example.Homewor_1.errorhandling.ResourceNotFoundException;

public interface Studentservice {

    
    public List<Student> getstudents();

    public Optional<Student> getstudent(int l) throws ResourceNotFoundException;

	public Student addstudent(Student student);

    public void delstudent(int l);
    
	public Student updatestudent(int i,Student student) throws ResourceNotFoundException;


}
