package com.Cockroach.repo;

import com.Cockroach.model.Cafe;
import com.Cockroach.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    @Query(value = "SELECT * FROM defaultdb.student", nativeQuery = true)
    List<Student> findAllStudentCustomQuery();
    @Query(value = "SELECT * FROM defaultdb.student WHERE student_id = ?1", nativeQuery = true)
    Optional<Student> findById(Long student_id);
}
