package com.springproject.controllers.rest;


import com.springproject.dto.StudentRequestDto;
import com.springproject.entities.student.Student;
import com.springproject.repos.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@Slf4j
public class StudentRestController {
@Autowired
    StudentRepository studentRepository;
    @GetMapping("/getAll")
    public @ResponseBody
    List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    @PostMapping("/add")
    public @ResponseBody String saveStudent(@RequestBody StudentRequestDto s)
    {
        try {
            studentRepository.save(new Student(s));
            return "success";
        }
        catch (Exception e)
        {
            log.warn("IN saveStudent: cannot save user {} \n Exception msg: {}", s.toString(),e.getMessage());
            return "failed";
        }
    }







}
