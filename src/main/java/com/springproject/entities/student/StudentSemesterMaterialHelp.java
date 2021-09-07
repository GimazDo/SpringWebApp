package com.springproject.entities.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class StudentSemesterMaterialHelp {
    @EmbeddedId
    private StudentSemesterKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("semesterId")
    @JoinColumn(name = "semester_id")
    private Semester semester;

    @Column(name = "status")
    private boolean status;
}
