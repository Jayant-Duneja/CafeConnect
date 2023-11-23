package com.Cockroach.repo;

import com.Cockroach.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Reviews, Long> {
    @Query(value = "SELECT * FROM public.reviews", nativeQuery = true)
    List<Reviews> findAllReviewsCustomQuery();
}
