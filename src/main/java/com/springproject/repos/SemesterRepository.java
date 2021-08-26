package com.springproject.repos;

import com.springproject.entities.student.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Long> {

    Semester findSemesterBySemester(String semester);
}
