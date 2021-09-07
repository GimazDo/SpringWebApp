package com.springproject.api;

import com.springproject.entities.User;
import com.springproject.entities.student.Semester;
import com.springproject.entities.student.Student;
import com.springproject.repos.SemesterRepository;
import com.springproject.repos.StudentRepository;
import com.springproject.services.StudentService;
import com.springproject.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@Slf4j
public class StudentResource {

    private final StudentService studentService;
    private final SemesterRepository semesterRepository;
    @CrossOrigin(origins = "*")
    @GetMapping("/getS")
    public List<Semester> getSemesters()
    {
        HashMap<String, List<Semester>>  s= new HashMap<>();
        s.put("s", semesterRepository.findAll());
        return semesterRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAll")
    public
    List<Student> getAllStudents()
    {

        List<Student> students = studentService.findAll();
        HashMap<String, List<Student>> s = new HashMap<>();
        s.put("students", students);
        return studentService.findAll();
    }

    @PostMapping("/add")
    public @ResponseBody String saveStudent(@RequestBody Student s)
    {
        try {
            studentService.save(s);
            return "success";
        }
        catch (Exception e)
        {
            log.warn("IN saveStudent: cannot save user {} \n Exception msg: {}", s.toString(),e.getMessage());
            return e.getMessage();
        }
    }

    @GetMapping("/getWithFilter")
    public  @ResponseBody List<Student> getWithFilter(@RequestBody String filter)
    {
        return studentService.findWithFilter(filter);

    }



}
