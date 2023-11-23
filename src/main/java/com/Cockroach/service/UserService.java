package com.Cockroach.service;

import com.Cockroach.model.Users;
import com.Cockroach.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo usersRepository;

    @Autowired
    public UserService(UserRepo usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public List<Users> getAllUsersCustomQuery() {
        return usersRepository.findAllUsersCustomQuery();
    }

    public void saveUser(Users user) {
        usersRepository.save(user);
    }

    public void deleteUser(int userId) {
        usersRepository.deleteById(userId);
    }
}
