package com.example.Homewor_1.controller;

import java.util.List;
import java.util.Optional;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Homewor_1.entities.Student;
import com.example.Homewor_1.errorhandling.ResourceNotFoundException;
import com.example.Homewor_1.service.Studentservice;

@RestController
@RequestMapping("/students")
public class StudentController {

@Autowired
private Studentservice studentservice;

@GetMapping
public List<Student> getstudents()
{
    return this.studentservice.getstudents();
}

@GetMapping("/{id}")
public ResponseEntity<Student> getStudent(@PathVariable String id) throws ResourceNotFoundException{
    Student get_student= this.studentservice.getstudent(Integer.parseInt(id)).orElseThrow(() -> new ResourceNotFoundException());
    return new ResponseEntity<>(get_student,HttpStatus.OK);

}

@PostMapping
public ResponseEntity<Student> addStudent(@RequestBody Student student)
{
    this.studentservice.addstudent(student);
    
    return new ResponseEntity<>(student,HttpStatus.CREATED);
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteStudent(@PathVariable String id) throws ResourceNotFoundException
{

    this.studentservice.getstudent(Integer.parseInt(id)).orElseThrow(() -> new ResourceNotFoundException());
    this.studentservice.delstudent(Integer.parseInt(id));
    return new ResponseEntity<String>(" Student id :" + id + " is deleted ", HttpStatus.OK);

}

@PutMapping("/{id}")
public ResponseEntity<String> updateStudent(@PathVariable String id,@RequestBody Student student) throws ResourceNotFoundException
{
    this.studentservice.getstudent(Integer.parseInt(id)).orElseThrow(() -> new ResourceNotFoundException());
    this.studentservice.updatestudent(Integer.parseInt(id), student);
    return new ResponseEntity<String>("Student with id: " + id +" is updated ", HttpStatus.OK);    
}

 
}
