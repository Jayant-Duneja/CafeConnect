package com.Cockroach.service;

import com.Cockroach.Observer.CafeConnectSubject;
import com.Cockroach.model.Menu;
import com.Cockroach.repo.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepo menuRepository;
    private static CafeConnectSubject cafeConnectSubject;

    @Autowired
    public MenuService(MenuRepo menuRepository,CafeConnectSubject cafeConnectSubject) {
        this.menuRepository = menuRepository;
        MenuService.cafeConnectSubject  =cafeConnectSubject;
    }
    public List<Menu> getAllMenuItems() {
        try {
            List<Menu> menuItems = menuRepository.findAll();
            logMessage("Successfully fetched all menu items");
            return menuItems;
        } catch (Exception e) {
            logMessage("Error fetching all menu items: " + e.getMessage());
            throw e; // rethrow the exception after logging
        }
    }

    public List<Menu> getMenuItemsByCafe(Long cafeId) {
        try {
            List<Menu> menuItems = menuRepository.findByCafe_Cafe_id(cafeId);
            logMessage("Successfully fetched menu items for cafe ID: " + cafeId);
            return menuItems;
        } catch (Exception e) {
            logMessage("Error fetching menu items by cafe ID: " + e.getMessage());
            throw e;
        }
    }

    public void saveMenuItem(Menu menu) {
        try {
            menuRepository.save(menu);
            logMessage("Successfully saved menu item");
        } catch (Exception e) {
            logMessage("Error saving menu item: " + e.getMessage());
            throw e;
        }
    }

    public void deleteMenuItem(Long itemId) {
        try {
            menuRepository.deleteById(itemId);
            logMessage("Successfully deleted menu item with ID " + itemId);
        } catch (Exception e) {
            logMessage("Error deleting menu item with ID " + itemId + ": " + e.getMessage());
            throw e;
        }
    }
    private static void logMessage(String message) {
        // Trigger the event and notify observers
        MenuService.cafeConnectSubject.setMessage(message);
    }
}
