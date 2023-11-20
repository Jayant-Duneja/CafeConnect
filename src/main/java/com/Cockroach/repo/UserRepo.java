package com.Cockroach.repo;

import com.Cockroach.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<Users, Integer> {

    @Query(value = "SELECT * FROM defaultdb.users", nativeQuery = true)
    List<Users> findAllUsersCustomQuery();
}
