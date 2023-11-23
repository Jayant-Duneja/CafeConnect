package com.Cockroach.service;

import com.Cockroach.model.Student;
import com.Cockroach.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo student) {
        this.studentRepo = student;
    }

    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    public List<Student> getAllStudentCustomQuery() {
        return studentRepo.findAllStudentCustomQuery();
    }

    public void saveUser(Student student) {
        studentRepo.save(student);
    }

    public void deleteUser(int student_id) {
        studentRepo.deleteById(student_id);
    }
}
