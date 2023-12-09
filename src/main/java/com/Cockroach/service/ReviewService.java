package com.Cockroach.service;

import com.Cockroach.model.Review;
import com.Cockroach.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Observable;

@Service
public class ReviewService {

    private final ReviewRepo reviewRepository;
    private final Observable observable;

    @Autowired
    public ReviewService(ReviewRepo reviewRepository, Observable observable) {
        this.reviewRepository = reviewRepository;
        this.observable = observable;
    }
    public List<Review> getAllReviews() {
        try {
            return reviewRepository.findAll();
        } catch (Exception e) {
            logMessage("Error retrieving all reviews: " + e.getMessage());
            return Collections.emptyList(); // or handle it in another way based on your requirements
        }
    }

    public List<Review> getAllReviewsCustomQuery() {
        try {
            return reviewRepository.findAllReviewsCustomQuery();
        } catch (Exception e) {
            logMessage("Error retrieving reviews with custom query: " + e.getMessage());
            return Collections.emptyList(); // or handle it in another way based on your requirements
        }
    }

    public void saveReview(Review review) {
        try {
            reviewRepository.save(review);
            logMessage("Successfully saved review with ID: " + review.getReview_id());
        } catch (Exception e) {
            logMessage("Error saving review: " + e.getMessage());
            // You might want to handle it in another way based on your requirements
        }
    }

    public void deleteReview(Long reviewId) {
        try {
            reviewRepository.deleteById(reviewId);
            logMessage("Successfully deleted review with ID: " + reviewId);
        } catch (Exception e) {
            logMessage("Error deleting review with ID: " + reviewId + ": " + e.getMessage());
            // You might want to handle it in another way based on your requirements
        }
    }
    private void logMessage(String message) {
        // Trigger the event and notify observers
        observable.hasChanged();
        observable.notifyObservers(message);
    }
}
