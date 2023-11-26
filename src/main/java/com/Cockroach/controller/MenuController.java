package com.Cockroach.controller;

import com.Cockroach.model.Menu;
import com.Cockroach.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/find")
    public List<Menu> getAllMenuItems() {
        return menuService.getAllMenuItems();
    }

    @GetMapping("/find/{cafeId}")
    public List<Menu> getMenuItemsByCafe(@PathVariable Long cafeId) {
        return menuService.getMenuItemsByCafe(cafeId);
    }

    @PostMapping("/add")
    public ResponseEntity<String> createMenuItem(@RequestBody Menu menu) {
        menuService.saveMenuItem(menu);
        return new ResponseEntity<>("Menu item created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update/{itemId}")
    public ResponseEntity<String> updateMenuItem(@PathVariable Long itemId, @RequestBody Menu menu) {
        menu.setItem_id(itemId);
        menuService.saveMenuItem(menu);
        return new ResponseEntity<>("Menu item updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<String> deleteMenuItem(@PathVariable Long itemId) {
        menuService.deleteMenuItem(itemId);
        return new ResponseEntity<>("Menu item deleted successfully", HttpStatus.OK);
    }
}
