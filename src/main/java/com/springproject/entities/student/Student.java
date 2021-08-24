package com.springproject.entities.student;

import com.springproject.dto.StudentRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private java.lang.String firstName;

    @Column(name = "sur_name")
    private java.lang.String surName;

    @Column(name = "last_name")
    private java.lang.String lastName;

    @Column(name = "gruppa")
    private int group;

    @Column(name = "faculty")
    private int faculty;

    @Column(name = "year_of_joining")
    private int yearOfJoining;

    @Column(name = "profile_ticket", unique = true)
    private long profileTicket;

    @Column(name = "study_form")
    private String studyForm;

    @OneToMany(mappedBy = "student")
    Set<StudentSemesterOplata> oplata;

    @OneToMany(mappedBy = "student")
    Set<StudentSemesterGrants> grants;
    public Student(java.lang.String firstName,
                   java.lang.String surName,
                   java.lang.String lastName,
                   int group,
                   int faculty,
                   int yearOfJoining,
                   long profileTicket,
                   String studyForm) {
        this.firstName = firstName;
        this.surName = surName;
        this.lastName = lastName;
        this.group = group;
        this.faculty = faculty;
        this.yearOfJoining = yearOfJoining;
        this.profileTicket = profileTicket;
        this.studyForm = studyForm;
    }

    public Student (StudentRequestDto s) {
        this.firstName = s.getFirstName();
        this.surName = s.getSurName();
        this.lastName = s.getLastName();
        this.group = s.getGroup();
        this.faculty = s.getFaculty();
        this.yearOfJoining = s.getYearOfJoining();
        this.profileTicket = s.getProfileTicket();
        this.studyForm = s.getString();
    }
    public StudentRequestDto toDto()
    {
        StudentRequestDto studentRequestDto = new StudentRequestDto();
        studentRequestDto.setFirstName(getFirstName());
        studentRequestDto.setSurName(getSurName());
        studentRequestDto.setGroup(getGroup());
        studentRequestDto.setFaculty(getFaculty());
        studentRequestDto.setString(getStudyForm());
        studentRequestDto.setYearOfJoining(getYearOfJoining());
        studentRequestDto.setProfileTicket(getProfileTicket());

        return studentRequestDto;
    }
}
