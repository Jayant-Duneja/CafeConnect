package com.Cockroach.service;

import com.Cockroach.model.Menu;
import com.Cockroach.model.Users;
import com.Cockroach.repo.MenuRepo;
import com.Cockroach.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MenuService {
    private final MenuRepo menuRepo;
    @Autowired
    public MenuService(MenuRepo menuRepo) {
        this.menuRepo = menuRepo;
    }

    public List<Menu> getAllItems() {
        return menuRepo.findAll();
    }

    public List<Menu> getAllMenuCustomQuery() {
        return menuRepo.findAllUsersCustomQuery();
    }
}
