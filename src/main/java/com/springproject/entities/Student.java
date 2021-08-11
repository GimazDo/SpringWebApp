package com.springproject.entities;

import com.springproject.dto.StudentRequestDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName,surName,lastName;

    private int gruppa;

    public Student() {
    }

    public Student(String firstName, String surName, String lastName, int gruppa) {
        this.firstName = firstName;
        this.surName = surName;
        this.lastName = lastName;
        this.gruppa = gruppa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGruppa() {
        return gruppa;
    }

    public void setGruppa(int gruppa) {
        this.gruppa = gruppa;
    }
    public static Student fromDto(StudentRequestDto s)
    {
        return new Student(s.getFirstName(), s.getSurName(), s.getLastName(), s.getGroup());
    }

}
