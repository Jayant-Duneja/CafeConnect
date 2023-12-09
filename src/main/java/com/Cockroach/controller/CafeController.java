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
public class CafeController extends BaseController {

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
        Cafe cafe = CafeService.getCafeById(cafeId);
        if (cafe != null) {
            return new ResponseEntity<>(cafe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> createCafe(@RequestBody Cafe cafe) {
        cafeService.saveCafe(cafe);
        return createSuccessResponse("Cafe created successfully");
    }

    @PutMapping("/find/{cafeId}")
    public ResponseEntity<String> updateCafe(@PathVariable String cafeId, @RequestBody Cafe cafe) {
        cafe.setCafe_id(cafeId);
        cafeService.saveCafe(cafe);
        return createSuccessResponse("Cafe updated successfully");
    }

    @DeleteMapping("/delete/{cafeId}")
    public ResponseEntity<String> deleteCafe(@PathVariable String cafeId) {
        cafeService.deleteCafe(Long.valueOf(cafeId));
        return createSuccessResponse("Cafe deleted successfully");
    }
}
