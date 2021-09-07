package com.springproject.services;

import com.springproject.entities.student.*;

import java.util.List;

public interface StudentService {


    public Student save(Student student);

    public List<Student> findAll();

    public List<Student> findWithFilter(String filter);

    public Semester addSemester(Semester semester);

    public boolean addPayment(StudentSemesterPayment studentSemesterPayment);

    public boolean  addGrants(StudentSemesterGrants studentSemesterGrants);

    public boolean addSocialNetwork(StudentSocialNetwork studentSocialNetwork);


}
