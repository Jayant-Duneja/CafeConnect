package com.Cockroach.controller;

import com.Cockroach.model.Review;
import com.Cockroach.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/find")
    public List<Review> getAllReviewsCustomQuery() {
        return reviewService.getAllReviewsCustomQuery();
    }

    @PostMapping("/add")
    public ResponseEntity<String> createReview(@RequestBody Review review) {
        reviewService.saveReview(review);
        return new ResponseEntity<>("Review created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/find/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId, @RequestBody Review review) {
        review.setReview_id(reviewId);
        reviewService.saveReview(review);
        return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
    }
}
