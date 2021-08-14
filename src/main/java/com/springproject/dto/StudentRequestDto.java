package com.springproject.dto;

import com.springproject.entities.StudyForm;
import lombok.Data;

@Data
public class StudentRequestDto {
    private String firstName;
    private String surName;
    private String lastName;
    private int group;
    private int faculty;
    private long profileTicket;
    private StudyForm studyForm;
    private int yearOfJoining;
}
