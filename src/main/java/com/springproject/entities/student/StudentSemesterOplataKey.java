package com.springproject.entities.student;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StudentSemesterOplataKey implements Serializable {
    @Column(name = "student_id")
    Long studentId;

    @Column(name = "semestr_id")
    Long semesterId;
}
