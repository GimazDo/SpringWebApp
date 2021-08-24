package com.springproject.entities.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StudentSemesterOplata {
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
