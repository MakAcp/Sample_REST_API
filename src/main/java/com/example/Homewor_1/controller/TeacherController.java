package com.example.Homewor_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Homewor_1.entities.Teacher;
import com.example.Homewor_1.errorhandling.ResourceNotFoundException;
import com.example.Homewor_1.service.Teacherservice;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
      
    
@Autowired
private Teacherservice teacherservice;

@GetMapping
public List<Teacher> getteachers()
{
    return this.teacherservice.getteachers();
}

@GetMapping("/{id}")
public ResponseEntity<Teacher> getTeacher(@PathVariable String id) throws ResourceNotFoundException{
    Teacher get_teacher= this.teacherservice.getteacher(Integer.parseInt(id)).orElseThrow(() -> new ResourceNotFoundException());
    return new ResponseEntity<>(get_teacher,HttpStatus.OK);

}

@PostMapping
public ResponseEntity<Teacher> addStudent(@RequestBody Teacher teacher)
{

    this.teacherservice.addteacher(teacher);
    return new ResponseEntity<>(teacher,HttpStatus.CREATED);

}


}
