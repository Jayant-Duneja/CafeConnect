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

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllUsers() {
        return studentService.getAllStudent();
    }

    @GetMapping("/find")
    public List<Student> getAllUsersCustomQuery() {
        return StudentService.getAllStudentCustomQuery();
    }

    @PostMapping("/add")
    public ResponseEntity<String> createUser(@RequestBody Student user) {
        studentService.saveUser(user);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/find/{userId}")
    public ResponseEntity<String> updateStudent(@PathVariable int userId, @RequestBody Student user) {
        user.setStudent_id(userId);
        studentService.saveUser(user);
        return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteStudent(@PathVariable int userId) {
        studentService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }
}
