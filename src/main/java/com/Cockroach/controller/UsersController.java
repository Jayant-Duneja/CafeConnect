package com.Cockroach.controller;

import com.Cockroach.model.Users;
import com.Cockroach.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UserService usersService;

    @Autowired
    public UsersController(UserService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/customQuery")
    public List<Users> getAllUsersCustomQuery() {
        return usersService.getAllUsersCustomQuery();
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody Users user) {
        usersService.saveUser(user);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable int userId, @RequestBody Users user) {
        user.setUserId(userId);
        usersService.saveUser(user);
        return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId) {
        usersService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }
}
