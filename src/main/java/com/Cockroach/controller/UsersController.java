package com.Cockroach.controller;

import com.Cockroach.model.Users;
import com.Cockroach.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
