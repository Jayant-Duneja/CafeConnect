package com.Cockroach.repo;

import com.Cockroach.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    @Query(value = "SELECT * FROM defaultdb.student", nativeQuery = true)
    List<Student> findAllStudentCustomQuery();
}
