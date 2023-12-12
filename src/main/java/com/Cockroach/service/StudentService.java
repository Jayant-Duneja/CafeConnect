package com.Cockroach.service;

import com.Cockroach.model.FriendNetwork;
import com.Cockroach.model.Student;
import com.Cockroach.repo.FriendNetworkRepo;
import com.Cockroach.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import com.Cockroach.Observer.CafeConnectSubject;
import com.Cockroach.model.Student;
import com.Cockroach.model.FriendNetwork;
import com.Cockroach.service.FriendNetworkService;
import com.Cockroach.repo.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private static StudentRepo studentRepo;
    private FriendNetworkService friendNetworkService;
    private static CafeConnectSubject cafeConnectSubject;

    @Autowired
    public StudentService(StudentRepo studentRepo, FriendNetworkService friendNetworkService, CafeConnectSubject cafeConnectSubject) {
        StudentService.studentRepo = studentRepo;
        this.friendNetworkService = friendNetworkService;
        StudentService.cafeConnectSubject = cafeConnectSubject;
    }

    public List<Student> getAllStudent() {
        try {
            List<Student> students = studentRepo.findAll();
            logMessage("Successfully fetched all students");
            return students;
        } catch (Exception e) {
            logMessage("Error fetching all students: " + e.getMessage());
            throw e;
        }
    }

    public static List<Student> getAllStudentCustomQuery() {
        try {
            List<Student> students = studentRepo.findAllStudentCustomQuery();
            logMessage("Successfully fetched all students using custom query");
            return students;
        } catch (Exception e) {
            logMessage("Error fetching students using custom query: " + e.getMessage());
            throw e;
        }
    }

    public void saveUser(Student student) {
        try {
            studentRepo.save(student);
            logMessage("Successfully saved student");
        } catch (Exception e) {
            logMessage("Error saving student: " + e.getMessage());
            throw e;
        }
    }

    public void deleteUser(int student_id) {
        try {
            studentRepo.deleteById(student_id);
            logMessage("Successfully deleted student with ID " + student_id);
        } catch (Exception e) {
            logMessage("Error deleting student with ID " + student_id + ": " + e.getMessage());
            throw e;
        }
    }

    public static Student getStudentById(long student_id) {
        try {
            return studentRepo.findById(student_id).orElse(null);
        } catch (Exception e) {
            logMessage("Error fetching student by ID " + student_id + ": " + e.getMessage());
            throw e;
        }
    }

    public void sendFriendRequest(Long senderId, Long recipientId) {
        try {
            Student sender = getStudentById(senderId);
            Student recipient = getStudentById(recipientId);
            if (sender != null && recipient != null) {
                friendNetworkService.sendFriendRequest(sender, recipient);
                logMessage("Successfully sent friend request from " + senderId + " to " + recipientId);
            }
        } catch (Exception e) {
            logMessage("Error sending friend request: " + e.getMessage());
            throw e;
        }
    }

    public void acceptFriendRequest(Long requestId) {
        try {
            friendNetworkService.acceptFriendRequest(requestId);
            logMessage("Successfully accepted friend request with ID " + requestId);
        } catch (Exception e) {
            logMessage("Error accepting friend request with ID " + requestId + ": " + e.getMessage());
            throw e;
        }
    }

    public void rejectFriendRequest(Long requestId) {
        try {
            friendNetworkService.rejectFriendRequest(requestId);
            logMessage("Successfully rejected friend request with ID " + requestId);
        } catch (Exception e) {
            logMessage("Error rejecting friend request with ID " + requestId + ": " + e.getMessage());
            throw e;
        }
    }

    public List<FriendNetwork> getPendingFriendRequests(Long studentId) {
        try {
            return friendNetworkService.getPendingFriendRequests(studentId);
        } catch (Exception e) {
            logMessage("Error fetching pending friend requests for student with ID " + studentId + ": " + e.getMessage());
            throw e;
        }
    }

    public List<FriendNetwork> getAllFriendsByStudentId(Long studentId) {
        try {
            return friendNetworkService.getAllFriendsByStudentId(studentId);
        } catch (Exception e) {
            logMessage("Error fetching all friends for student with ID " + studentId + ": " + e.getMessage());
            throw e;
        }
    }

    private static void logMessage(String message) {
        // Trigger the event and notify observers
        cafeConnectSubject.setMessage(message);
    }
}
