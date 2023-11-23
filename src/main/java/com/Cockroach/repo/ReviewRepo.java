package com.Cockroach.repo;

import com.Cockroach.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Long> {
    @Query(value = "SELECT * FROM defaultdb.review", nativeQuery = true)
    List<Review> findAllReviewsCustomQuery();
}
