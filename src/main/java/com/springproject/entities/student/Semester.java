package com.springproject.entities.student;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "semester", unique = true)
    private String semester;




}
