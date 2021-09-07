package com.springproject.entities.student;

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

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "hostel", nullable = true)
    private String hostel;

    @OneToMany(mappedBy = "student")
    Set<StudentSocialNetwork> socialNetworks;

    @OneToMany(mappedBy = "student")
    Set<StudentSemesterMaterialHelp> materialHelps;

    @OneToMany(mappedBy = "student")
    Set<StudentSemesterPayment> payment;

    @OneToMany(mappedBy = "student")
    Set<StudentSemesterGrants> grants;


    public Student(String firstName, String surName, String lastName,
                   int group, int faculty, int yearOfJoining,
                   long profileTicket, String studyForm, String phoneNumber,
                   String hostel, Set<StudentSocialNetwork> socialNetworks,
                   Set<StudentSemesterMaterialHelp> materialHelps,
                   Set<StudentSemesterPayment> payment, Set<StudentSemesterGrants> grants) {
        this.firstName = firstName;
        this.surName = surName;
        this.lastName = lastName;
        this.group = group;
        this.faculty = faculty;
        this.yearOfJoining = yearOfJoining;
        this.profileTicket = profileTicket;
        this.studyForm = studyForm;
        this.phoneNumber = phoneNumber;
        this.hostel = hostel;
        this.socialNetworks = socialNetworks;
        this.materialHelps = materialHelps;
        this.payment = payment;
        this.grants = grants;
    }
}
