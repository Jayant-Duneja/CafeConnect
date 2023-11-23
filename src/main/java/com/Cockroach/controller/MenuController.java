package com.Cockroach.controller;

import com.Cockroach.model.Menu;
import com.Cockroach.repo.MenuRepo;
import com.Cockroach.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    private final MenuService menuService;
    private final MenuRepo menuRepo;
    @Autowired
    public MenuController(MenuService menuService, MenuRepo menuRepo){
        this.menuService=menuService;
        this.menuRepo = menuRepo;
    }
    @GetMapping
    public List<Menu> getAllUsers() {
        return menuService.getAllItems();
    }
    @GetMapping("/customQuery")
    public List<Menu> getAllMenuCustomQuery() {
        return menuService.getAllMenuCustomQuery();
    }
    @PostMapping("/add")
    public Menu addMenuItem(@RequestBody Menu menu) {
        // You can add additional validation or business logic here before saving to the database
        return menuRepo.save(menu);
    }

    @DeleteMapping("/delete/{item_id}")
    public void deleteMenuItem(@PathVariable int item_id) {
        // You can add additional validation or business logic here before deleting from the database
        menuRepo.deleteById(item_id);
    }

}
