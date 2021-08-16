package com.springproject.repos;

import com.springproject.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findAllBySurName(String surName);
}
