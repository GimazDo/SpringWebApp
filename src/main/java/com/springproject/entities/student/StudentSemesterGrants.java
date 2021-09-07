package com.springproject.entities.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentSemesterGrants {
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

    @Column(name = "type")
    private String type;


}
