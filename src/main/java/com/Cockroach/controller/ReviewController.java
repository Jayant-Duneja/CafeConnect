package com.Cockroach.controller;

import com.Cockroach.model.Reviews;
import com.Cockroach.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Reviews> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/customQuery")
    public List<Reviews> getAllReviewsCustomQuery() {
        return reviewService.getAllReviewsCustomQuery();
    }

    @PostMapping
    public ResponseEntity<String> createReview(@RequestBody Reviews review) {
        reviewService.saveReview(review);
        return new ResponseEntity<>("Review created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId, @RequestBody Reviews review) {
        review.setReviewid(reviewId);
        reviewService.saveReview(review);
        return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
    }
}
