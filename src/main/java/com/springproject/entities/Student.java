package com.springproject.entities;

import com.springproject.dto.StudentRequestDto;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name = "sur_name")
    private String surName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gruppa")
    private int group;

    @Column(name = "faculty")
    private int faculty;

    @Column(name = "year_of_joining")
    private int yearOfJoining;

    @Column(name = "profile_ticket")
    private long profileTicket;

    @Column(name = "study_form")
    private StudyForm studyForm;





    public Student() {
    }

   //Доделать
    public static Student fromDto(StudentRequestDto s)
    {
        return new Student();
    }

}
