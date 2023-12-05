package com.Cockroach.service;

import com.Cockroach.model.Student;
import com.Cockroach.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Observable;

@Service
public class StudentService {

    private static StudentRepo studentRepo;
    private static Observable observable;

    @Autowired
    public StudentService(StudentRepo student, Observable observable) {
        this.studentRepo = student;
        this.observable = observable;
    }

    public List<Student> getAllStudents() {
        try {
            return studentRepo.findAll();
        } catch (Exception e) {
            logMessage("Error retrieving all students: " + e.getMessage());
            return Collections.emptyList(); // or handle it in another way based on your requirements
        }
    }

    public List<Student> getAllStudentsCustomQuery() {
        try {
            return studentRepo.findAllStudentCustomQuery();
        } catch (Exception e) {
            logMessage("Error retrieving students with custom query: " + e.getMessage());
            return Collections.emptyList(); // or handle it in another way based on your requirements
        }
    }

    public void saveStudent(Student student) {
        try {
            studentRepo.save(student);
            logMessage("Successfully saved student with ID: " + student.getStudent_id());
        } catch (Exception e) {
            logMessage("Error saving student: " + e.getMessage());
            // You might want to handle it in another way based on your requirements
        }
    }

    public void deleteStudent(int studentId) {
        try {
            studentRepo.deleteById(studentId);
            logMessage("Successfully deleted student with ID: " + studentId);
        } catch (Exception e) {
            logMessage("Error deleting student with ID: " + studentId + ": " + e.getMessage());
            // You might want to handle it in another way based on your requirements
        }
    }

    public static Student getStudentById(long studentId) {
        try {
            return studentRepo.findById(studentId).orElse(null);
        } catch (Exception e) {
            logMessage("Error retrieving student with ID: " + studentId + ": " + e.getMessage());
            return null; // or handle it in another way based on your requirements
        }
    }
    private static void logMessage(String message) {
        // Trigger the event and notify observers
        observable.hasChanged();
        observable.notifyObservers(message);
    }
}
