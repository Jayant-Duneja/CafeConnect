package com.Cockroach.controller;

import com.Cockroach.model.Cafe;
import com.Cockroach.model.Student;
import com.Cockroach.service.CafeStudentService;
import com.Cockroach.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/notify")
public class StudentCafeController {
    private final CafeStudentService cafeStudentService;

    @Autowired
    public StudentCafeController(CafeStudentService cafeStudentService) {
        this.cafeStudentService = cafeStudentService;
    }
    @PostMapping("/add")
    public ResponseEntity<String> cafeAddStudent(@RequestBody Map<String, String> requestBody) {
        Long cafe_id = Long.valueOf(requestBody.get("cafe_id"));
        Long student_id = Long.valueOf(requestBody.get("student_id"));
        cafeStudentService.saveEntry(cafe_id, student_id);
        return new ResponseEntity<>("Students registered to cafe Successfully", HttpStatus.CREATED);
    }
    @PostMapping("/remove")
    public ResponseEntity<String> cafeRemoveStudent(@RequestBody Map<String, String> requestBody) {
        Long cafe_id = Long.valueOf(requestBody.get("cafe_id"));
        Long student_id = Long.valueOf(requestBody.get("student_id"));
        cafeStudentService.deleteEntry(cafe_id, student_id);
        return new ResponseEntity<>("Students unsubscribed from Cafe", HttpStatus.CREATED);
    }
    @PostMapping("send")
    public ResponseEntity<String> cafeNotify(@RequestBody Map<String, String> requestBody) {
        Long cafe_id = Long.valueOf(requestBody.get("cafe_id"));
        String message = requestBody.get("message");
        cafeStudentService.notifyStudents(cafe_id, message);
        return new ResponseEntity<>("Students notified Successfully", HttpStatus.CREATED);
    }

}
