package com.springproject.controllers;

import com.springproject.entities.Student;
import com.springproject.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class StudentController {

    @Value("${upload.path}")
    private String uploadPath;
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("/student/add")
    public String mainPage(Model model, Principal principal)
    {
        model.addAttribute("username", principal.getName());
        return "student/addStudent";
    }

    @GetMapping("/student/showAll")
    public String showAllStudents(Model model, Principal principal)
    {
        model.addAttribute("username", principal.getName());
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "student/showStudent";
    }
    
//    @PostMapping("/student/add")
//    public String addStudent(@RequestParam String firstName,
//                             @RequestParam String surName,
//                             @RequestParam String lastName,
//                             @RequestParam int group, Model model)
//    {
//        Student student = new Student(firstName,surName,lastName,group);
//        studentRepository.save(student);
//        return "home";
//    }

    @GetMapping("/student/showAllPanel")
    public String showSt(Model model)
    {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "student/showStudentPanel";
    }
//    @PostMapping("/student/fromFile")
//    public String convertFromFile(@RequestParam MultipartFile file)
//    {
//        Iterable<Student> students = convertFromExelToDB(file);
//        studentRepository.saveAll(students);
//        return "home";
//    }
//    @GetMapping("/student")
//    public String showSort(Model model)
//    {
//        return "studentMain";
//    }
//
//
//    public Iterable<Student> convertFromExelToDB(MultipartFile file)
//    {
//        ArrayList<Student> students = new ArrayList<Student>();
//        String firstName = "", surName="",lastName=""; int gruppa =0;
//        try {
//            String text = new BufferedReader(
//                    new InputStreamReader( file.getInputStream(), StandardCharsets.UTF_16))
//                    .lines()
//                    .collect(Collectors.joining("\n"));
//            System.out.println(text);
//            String[] ss = text.split("\n");
//            for (String s: ss) {
//                char tab = '\t';
//                String[] st = s.split(String.valueOf(tab));
//                Student student = new Student(st[1],st[0],st[2],Integer.parseInt(st[3]));
//                students.add(student);
//            }
//        }
//        catch (IOException sa)
//        {
//
//        }
//        return students;
//    }

}
