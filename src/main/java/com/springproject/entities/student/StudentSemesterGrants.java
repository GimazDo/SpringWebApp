package com.springproject.entities.student;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class StudentSemesterGrants {
    @EmbeddedId
    StudentSemesterOplataKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne
    @MapsId("semesterId")
    @JoinColumn(name = "semester_id")
    Semester semester;

    boolean oplata;

}
