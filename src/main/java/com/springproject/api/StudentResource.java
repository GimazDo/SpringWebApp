package com.springproject.api;

import com.springproject.dto.StudentRequestDto;
import com.springproject.entities.User;
import com.springproject.entities.student.Student;
import com.springproject.repos.StudentRepository;
import com.springproject.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@Slf4j
public class StudentResource {

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
