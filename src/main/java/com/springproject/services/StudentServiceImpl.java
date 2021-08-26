package com.springproject.services;

import com.springproject.entities.student.*;
import com.springproject.repos.SemesterRepository;
import com.springproject.repos.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class StudentServiceImpl  implements StudentService {

    private final StudentRepository studentRepository;
    private final SemesterRepository semesterRepository;


    @Override
    public Student save(Student student) {
        log.info("Save a student with profile ticket {}", student.getProfileTicket());
       return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        log.info("Return all students in DB");
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findWithFilter(String filter) {
        return null;
    }

    @Override
    public Semester addSemester(Semester semester) {
        log.info("Add new semester {}", semester);
        return  semesterRepository.save(semester);
    }

    @Override
    public void addPayment(int profileTicket, String semester, boolean payment) {
        Student student = studentRepository.findStudentByProfileTicket(profileTicket);
        Semester semester1 = semesterRepository.findSemesterBySemester(semester);
        StudentSemesterPayment studentSemesterPayment = new StudentSemesterPayment(
                new StudentSemesterKey(student.getId(), semester1.getId()),
                student,
                semester1,
                LocalDateTime.now(),
                payment);
        student.getPayment().add(studentSemesterPayment);
        log.info("Payment({}) (semester {}) is assigned to student with profile ticket {}",payment, semester, profileTicket);
    }

    @Override
    public void addGrants(int profileTicket, String semester, boolean payment) {
        Student student = studentRepository.findStudentByProfileTicket(profileTicket);
        Semester semester1 = semesterRepository.findSemesterBySemester(semester);
        StudentSemesterGrants studentSemesterGrants = new StudentSemesterGrants(
                new StudentSemesterKey(student.getId(), semester1.getId()),
                student,
                semester1,
                LocalDateTime.now(),
                payment);

        student.getGrants().add(studentSemesterGrants);
        log.info("Grants({}) (semester {}) is assigned to student with profile ticket {}",payment, semester, profileTicket);
    }
}
