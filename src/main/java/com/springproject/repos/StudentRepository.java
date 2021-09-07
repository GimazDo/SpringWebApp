package com.springproject.repos;

import com.springproject.entities.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findAllBySurName(String surName);

    public Student findStudentByProfileTicket(long profileTicket);
}
