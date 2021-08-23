package com.springproject.controllers;

import com.springproject.entities.student.Student;
import com.springproject.entities.student.StudyForm;
import com.springproject.repos.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@Slf4j
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("/add")
    public String mainPage(Model model, Principal principal)
    {
        model.addAttribute("username", principal.getName());
        return "student/addStudent";
    }

    @GetMapping("/showAll")
    public String showAllStudents(Model model, Principal principal)
    {
        model.addAttribute("username", principal.getName());
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "student/showStudent";
    }

    @GetMapping("/find")
    public String getFindPage(@RequestParam (value = "surname", required = false) String surname, Model model, Principal principal)
    {
        model.addAttribute("students", studentRepository.findAllBySurName(surname));
        model.addAttribute("username", principal.getName());
        return "student/findStudent";
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

    @GetMapping("/showAllPanel")
    public String showSt(Model model)
    {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "student/showStudentPanel";
    }
    @PostMapping("/fromFile")
    public String convertFromFile(@RequestParam MultipartFile file)
    {
        List<Student> students = convertFromExelToDB(file);
        studentRepository.saveAll(students);
        return "home";
    }
    @GetMapping("/")
    public String showSort(Model model)
    {
        return "studentMain";
    }


    public List<Student> convertFromExelToDB(MultipartFile file)
    {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            String text = new BufferedReader(
                    new InputStreamReader( file.getInputStream(), StandardCharsets.UTF_16))
                    .lines()
                    .collect(Collectors.joining("\n"));
            System.out.println(text);
            String[] ss = text.split("\n");
            for (String s: ss) {
                char tab = '\t';

                StudyForm studyForm;
                String[] st = s.split(String.valueOf(tab));
                if(st[7] == "K") {
                    studyForm = StudyForm.contract;
                }
                else
                {
                    studyForm = StudyForm.budget;
                }
                Student student = new Student(st[1],st[0],st[2],Integer.parseInt(st[3]),Integer.parseInt(st[4]),Integer.parseInt(st[5]),Long.parseLong(st[6]), studyForm);
                students.add(student);
            }
        }
        catch (IOException sa)
        {
            log.warn("IN convertFromExelToDB: Cannot convert \n StackTrace: {}", sa.getStackTrace());
        }
        return students;
    }

}
