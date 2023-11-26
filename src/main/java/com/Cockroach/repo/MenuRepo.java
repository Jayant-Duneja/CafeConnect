package com.Cockroach.repo;

import com.Cockroach.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepo extends JpaRepository<Menu, Long> {
    @Query(value = "SELECT * FROM defaultdb.menu", nativeQuery = true)
    List<Menu> findAll();

    @Query(value = "SELECT * FROM defaultdb.menu WHERE cafe_id = ?1", nativeQuery = true)
    List<Menu> findByCafe_Cafe_id(Long cafeId);
}
