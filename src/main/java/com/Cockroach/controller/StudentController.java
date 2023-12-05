package com.Cockroach.controller;

import com.Cockroach.model.Student;
import com.Cockroach.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private static StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllUsers() {
        return studentService.getAllStudents();
    }

    @GetMapping("/find")
    public static List<Student> getAllUsersCustomQuery() {
        return studentService.getAllStudentsCustomQuery();
    }

    @PostMapping("/add")
    public ResponseEntity<String> createUser(@RequestBody Student user) {
        studentService.saveStudent(user);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/find/{userId}")
    public ResponseEntity<String> updateStudent(@PathVariable int userId, @RequestBody Student user) {
        user.setStudent_id(userId);
        studentService.saveStudent(user);
        return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteStudent(@PathVariable int student_id) {
        studentService.deleteStudent(student_id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }
}
