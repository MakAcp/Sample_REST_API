package com.example.Homewor_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Homewor_1.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
    
}
