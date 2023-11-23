package com.Cockroach.service;

import com.Cockroach.model.Reviews;
import com.Cockroach.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepo reviewRepository;

    @Autowired
    public ReviewService(ReviewRepo reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Reviews> getAllReviews() {
        return reviewRepository.findAll();
    }

    public List<Reviews> getAllReviewsCustomQuery() {
        return reviewRepository.findAllReviewsCustomQuery();
    }

    public void saveReview(Reviews review) {
        reviewRepository.save(review);
    }

    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
