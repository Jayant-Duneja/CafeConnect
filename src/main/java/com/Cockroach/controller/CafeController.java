package com.Cockroach.controller;

import com.Cockroach.model.Cafe;
import com.Cockroach.model.Student;
import com.Cockroach.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/find/{cafeId}")
    public ResponseEntity<Cafe> getCafeById(@PathVariable String cafeId) {
        Cafe cafe = cafeService.getCafeById(cafeId);
        if (cafe != null) {
            return new ResponseEntity<>(cafe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> createCafe(@RequestBody Cafe cafe) {
        cafeService.saveCafe(cafe);
        return new ResponseEntity<>("Cafe created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/find/{cafeId}")
    public ResponseEntity<String> updateCafe(@PathVariable String cafeId, @RequestBody Cafe cafe) {
        cafe.setCafe_id(cafeId);
        cafeService.saveCafe(cafe);
        return new ResponseEntity<>("Cafe updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cafeId}")
    public ResponseEntity<String> deleteCafe(@PathVariable String cafeId) {
        cafeService.deleteCafe(Long.valueOf(cafeId));
        return new ResponseEntity<>("Cafe deleted successfully", HttpStatus.OK);
    }
}
