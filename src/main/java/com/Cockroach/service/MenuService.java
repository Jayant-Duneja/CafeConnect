package com.Cockroach.service;

import com.Cockroach.model.Menu;
import com.Cockroach.repo.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Observable;

@Service
public class MenuService {

    private final MenuRepo menuRepository;
    private final Observable observable;

    @Autowired
    public MenuService(MenuRepo menuRepository, Observable observable) {
        this.menuRepository = menuRepository;
        this.observable = observable;
    }
    public List<Menu> getAllMenuItems() {
        try {
            return menuRepository.findAll();
        } catch (Exception e) {
            logMessage("Error retrieving all menu items: " + e.getMessage());
            return Collections.emptyList(); // or handle it in another way based on your requirements
        }
    }

    public List<Menu> getMenuItemsByCafe(Long cafeId) {
        try {
            return menuRepository.findByCafe_Cafe_id(cafeId);
        } catch (Exception e) {
            logMessage("Error retrieving menu items for cafeId " + cafeId + ": " + e.getMessage());
            return Collections.emptyList(); // or handle it in another way based on your requirements
        }
    }

    public void saveMenuItem(Menu menu) {
        try {
            menuRepository.save(menu);
            logMessage("Successfully saved menu item with ID: " + menu.getItem_id());
        } catch (Exception e) {
            logMessage("Error saving menu item: " + e.getMessage());
            // You might want to handle it in another way based on your requirements
        }
    }

    public void deleteMenuItem(Long itemId) {
        try {
            menuRepository.deleteById(itemId);
            logMessage("Successfully deleted menu item with ID: " + itemId);
        } catch (Exception e) {
            logMessage("Error deleting menu item with ID: " + itemId + ": " + e.getMessage());
            // You might want to handle it in another way based on your requirements
        }
    }
    private void logMessage(String message) {
        // Trigger the event and notify observers
        observable.hasChanged();
        observable.notifyObservers(message);
    }
}
