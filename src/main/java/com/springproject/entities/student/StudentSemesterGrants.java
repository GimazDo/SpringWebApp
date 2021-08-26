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
    StudentSemesterKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne
    @MapsId("semesterId")
    @JoinColumn(name = "semester_id")
    Semester semester;


    @Column(name = "payment_time")
    LocalDateTime paymentTime;

    boolean payment;

}
