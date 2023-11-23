package com.Cockroach.controller;

import com.Cockroach.model.Cafe;
import com.Cockroach.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cafe")
public class CafeController {

    private final CafeService cafeService;

    @Autowired
    public CafeController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    @GetMapping
    public List<Cafe> getAllCafes() {
        return cafeService.getAllCafes();
    }

    @GetMapping("/find")
    public List<Cafe> getAllCafesCustomQuery() {
        return cafeService.getAllCafesCustomQuery();
    }

    @PostMapping("/add")
    public ResponseEntity<String> createCafe(@RequestBody Cafe cafe) {
        cafeService.saveCafe(cafe);
        return new ResponseEntity<>("Cafe created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/find/{cafeId}")
    public ResponseEntity<String> updateCafe(@PathVariable Long cafeId, @RequestBody Cafe cafe) {
        cafe.setCafe_id(cafeId);
        cafeService.saveCafe(cafe);
        return new ResponseEntity<>("Cafe updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cafeId}")
    public ResponseEntity<String> deleteCafe(@PathVariable Long cafeId) {
        cafeService.deleteCafe(cafeId);
        return new ResponseEntity<>("Cafe deleted successfully", HttpStatus.OK);
    }
}
