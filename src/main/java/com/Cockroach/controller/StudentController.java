package com.Cockroach.controller;

import com.Cockroach.model.FriendNetwork;
import com.Cockroach.model.Student;
import com.Cockroach.service.FriendNetworkService;
import com.Cockroach.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// Other imports...

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;
    private FriendNetworkService friendNetworkService;

    @Autowired
    public StudentController(StudentService studentService, FriendNetworkService friendNetworkService) {
        this.studentService = studentService;
        this.friendNetworkService = friendNetworkService;
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

    @PutMapping("/update/{student_id}")
    public ResponseEntity<String> updateStudent(@PathVariable int student_id, @RequestBody Student user) {
        user.setStudent_id(student_id);
        studentService.saveUser(user);
        return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{student_id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int student_id) {
        studentService.deleteUser(student_id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/friend-request/send/{senderId}/{recipientId}")
    public ResponseEntity<String> sendFriendRequest(@PathVariable Long senderId, @PathVariable Long recipientId) {
        studentService.sendFriendRequest(senderId, recipientId);
        return new ResponseEntity<>("Friend request sent successfully", HttpStatus.OK);
    }

    @GetMapping("/friend-request/accept/{requestId}")
    public ResponseEntity<String> acceptFriendRequest(@PathVariable Long requestId) {
        studentService.acceptFriendRequest(requestId);
        return new ResponseEntity<>("Friend request accepted successfully", HttpStatus.OK);
    }

    @GetMapping("/friend-request/reject/{requestId}")
    public ResponseEntity<String> rejectFriendRequest(@PathVariable Long requestId) {
        studentService.rejectFriendRequest(requestId);
        return new ResponseEntity<>("Friend request rejected successfully", HttpStatus.OK);
    }

    @GetMapping("/friend-request/pending/{studentId}")
    public ResponseEntity<List<FriendNetwork>> getPendingFriendRequests(@PathVariable Long studentId) {
        List<FriendNetwork> pendingFriendRequests = studentService.getPendingFriendRequests(studentId);

        if (pendingFriendRequests != null && !pendingFriendRequests.isEmpty()) {
            return new ResponseEntity<>(pendingFriendRequests, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/friends/{studentId}")
    public ResponseEntity<List<FriendNetwork>> getAllFriendsByStudentId(@PathVariable Long studentId) {
        List<FriendNetwork> friends = studentService.getAllFriendsByStudentId(studentId);

        if (friends != null && !friends.isEmpty()) {
            return new ResponseEntity<>(friends, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
