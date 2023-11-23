package com.Cockroach.repo;

import com.Cockroach.model.Menu;
import com.Cockroach.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepo extends JpaRepository<Menu, Integer> {

    @Query(value = "SELECT * FROM defaultdb.menu", nativeQuery = true)
    List<Menu> findAllUsersCustomQuery();
}