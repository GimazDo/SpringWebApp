package com.springproject.services;

import com.springproject.entities.student.Semester;
import com.springproject.entities.student.Student;

import java.util.List;

public interface StudentService {


    public Student save(Student student);

    public List<Student> findAll();

    public List<Student> findWithFilter(String filter);

    public Semester addSemester(Semester semester);

    public void addPayment(int profileTicket, String semester, boolean payment);

    public void  addGrants(int profileTicket, String semester, boolean payment);

}
