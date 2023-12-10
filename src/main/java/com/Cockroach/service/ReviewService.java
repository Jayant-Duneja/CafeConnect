package com.Cockroach.service;

import com.Cockroach.Observer.CafeConnectSubject;
import com.Cockroach.model.Review;
import com.Cockroach.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepo reviewRepository;
    private static CafeConnectSubject cafeConnectSubject;

    @Autowired
    public ReviewService(ReviewRepo reviewRepository, CafeConnectSubject cafeConnectSubject) {
        this.reviewRepository = reviewRepository;
        ReviewService.cafeConnectSubject = cafeConnectSubject;
    }

    public List<Review> getAllReviews() {
        try {
            List<Review> reviews = reviewRepository.findAll();
            logMessage("Successfully fetched all reviews");
            return reviews;
        } catch (Exception e) {
            logMessage("Error fetching all reviews: " + e.getMessage());
            throw e;
        }
    }

    public List<Review> getAllReviewsCustomQuery() {
        try {
            List<Review> reviews = reviewRepository.findAllReviewsCustomQuery();
            logMessage("Successfully fetched all reviews using custom query");
            return reviews;
        } catch (Exception e) {
            logMessage("Error fetching reviews using custom query: " + e.getMessage());
            throw e;
        }
    }

    public void saveReview(Review review) {
        try {
            reviewRepository.save(review);
            logMessage("Successfully saved review");
        } catch (Exception e) {
            logMessage("Error saving review: " + e.getMessage());
            throw e;
        }
    }

    public void deleteReview(Long reviewId) {
        try {
            reviewRepository.deleteById(reviewId);
            logMessage("Successfully deleted review with ID " + reviewId);
        } catch (Exception e) {
            logMessage("Error deleting review with ID " + reviewId + ": " + e.getMessage());
            throw e;
        }
    }

    private static void logMessage(String message) {
        // Trigger the event and notify observers
        ReviewService.cafeConnectSubject.setMessage(message);
        System.out.println("Notified all Observers");
    }
}