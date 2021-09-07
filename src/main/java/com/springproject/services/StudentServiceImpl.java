package com.springproject.services;

import com.springproject.entities.student.*;
import com.springproject.repos.SemesterRepository;
import com.springproject.repos.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
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

        String[] s = filter.split(" ");

        switch (s[1])
        {
            case "firstName": ;
            case "lastName": ;
            case "surName": ;
            case "faculty": ;
        }


        return null;
    }

    @Override
    public Semester addSemester(Semester semester) {
        log.info("Add new semester {}", semester);
        return  semesterRepository.save(semester);
    }

    @Override
    public boolean addPayment(StudentSemesterPayment studentSemesterPayment) {
        Student student = studentRepository.findStudentByProfileTicket(studentSemesterPayment.getStudent().getProfileTicket());
        if(student==null)
        {
           return false;
        }
        student.getPayment().add(studentSemesterPayment);
        log.info("Payment({}) (semester {}) is assigned to student with profile ticket {}",
                studentSemesterPayment.isPayment(),studentSemesterPayment.getSemester().getSemester(),
                studentSemesterPayment.getStudent().getProfileTicket());
        return true;
    }

    @Override
    public boolean addGrants(StudentSemesterGrants studentSemesterGrants) {

        Student student = studentRepository.findStudentByProfileTicket(studentSemesterGrants.getStudent().getProfileTicket());
        if(student==null)
        {
            return false;
        }
        student.getGrants().add(studentSemesterGrants);
        log.info("Grants({}) with type {} (semester {}) is assigned to student with profile ticket {}",
                studentSemesterGrants.isStatus(),studentSemesterGrants.getType(),
                studentSemesterGrants.getSemester().getSemester(), studentSemesterGrants.getStudent().getProfileTicket());
        return true;
    }

    @Override
    public boolean addSocialNetwork(StudentSocialNetwork studentSocialNetwork) {
        Student student = studentRepository.findStudentByProfileTicket(studentSocialNetwork.getStudent().getProfileTicket());
        if(student==null)
        {
            return false;
        }
        student.getSocialNetworks().add(studentSocialNetwork);
        log.info("Social network ({} :{}) id assigned to student with profile ticket {}",
                studentSocialNetwork.getSocialNetworkId().getType(),studentSocialNetwork.getUrl(),studentSocialNetwork.getStudent().getProfileTicket());

        return true;
    }
}
