package com.springproject.entities.student;

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


    public Student(String firstName,
                   String surName,
                   String lastName,
                   int group,
                   int faculty,
                   int yearOfJoining,
                   long profileTicket,
                   StudyForm studyForm) {
        this.firstName = firstName;
        this.surName = surName;
        this.lastName = lastName;
        this.group = group;
        this.faculty = faculty;
        this.yearOfJoining = yearOfJoining;
        this.profileTicket = profileTicket;
        this.studyForm = studyForm;
    }

    public Student() {
    }

    public Student (StudentRequestDto s) {
        this.firstName = s.getFirstName();
        this.surName = s.getSurName();
        this.lastName = s.getLastName();
        this.group = s.getGroup();
        this.faculty = s.getFaculty();
        this.yearOfJoining = s.getYearOfJoining();
        this.profileTicket = s.getProfileTicket();
        this.studyForm = s.getStudyForm();
    }
    public StudentRequestDto toDto()
    {
        StudentRequestDto studentRequestDto = new StudentRequestDto();
        studentRequestDto.setFirstName(getFirstName());
        studentRequestDto.setSurName(getSurName());
        studentRequestDto.setGroup(getGroup());
        studentRequestDto.setFaculty(getFaculty());
        studentRequestDto.setStudyForm(getStudyForm());
        studentRequestDto.setYearOfJoining(getYearOfJoining());
        studentRequestDto.setProfileTicket(getProfileTicket());

        return studentRequestDto;
    }
}
