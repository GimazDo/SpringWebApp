package com.springproject.entities.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StudentSemesterPayment {
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
