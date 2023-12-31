package com.Cockroach.repo;

import com.Cockroach.model.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CafeRepo extends JpaRepository<Cafe, Long> {
    @Query(value = "SELECT * FROM defaultdb.cafe", nativeQuery = true)
    List<Cafe> findAllCafesCustomQuery();
    @Query(value = "SELECT * FROM defaultdb.cafe WHERE cafe_id = ?1", nativeQuery = true)
    Optional<Cafe> findById(Long cafeId);
}
