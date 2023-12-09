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

@Service
public class StudentService {

    private static StudentRepo studentRepo;
    private FriendNetworkService friendNetworkService;

    @Autowired
    public StudentService(StudentRepo studentRepo, FriendNetworkService friendNetworkService) {
        this.studentRepo = studentRepo;
        this.friendNetworkService = friendNetworkService;
    }

    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    public static List<Student> getAllStudentCustomQuery() {
        return studentRepo.findAllStudentCustomQuery();
    }

    public void saveUser(Student student) {
        studentRepo.save(student);
    }

    public void deleteUser(int student_id) {
        studentRepo.deleteById(student_id);
    }
    public static Student getStudentById(long student_id) {
        return studentRepo.findById(student_id).orElse(null);
    }

    public void sendFriendRequest(Long senderId, Long recipientId) {
        Student sender = getStudentById(senderId);
        Student recipient = getStudentById(recipientId);

        System.out.println("sender: " + sender);
        System.out.println("recipient: " + recipient);

        if (sender != null && recipient != null) {
            friendNetworkService.sendFriendRequest(sender, recipient);
        }
    }

    public void acceptFriendRequest(Long requestId) {
        friendNetworkService.acceptFriendRequest(requestId);
    }

    public void rejectFriendRequest(Long requestId) {
        friendNetworkService.rejectFriendRequest(requestId);
    }

    public List<FriendNetwork> getPendingFriendRequests(Long studentId) {
        return friendNetworkService.getPendingFriendRequests(studentId);
    }

    public List<FriendNetwork> getAllFriendsByStudentId(Long studentId) {
        return friendNetworkService.getAllFriendsByStudentId(studentId);
    }
}
