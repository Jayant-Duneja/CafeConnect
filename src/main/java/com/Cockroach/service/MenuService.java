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
        // Check if a special discount is provided
        Double specialDiscount = menu.getSpecialDiscount();

        // Create Menu instance with or without a special discount using the factory pattern
        Menu menuWithDiscount = new Menu(
                menu.getItem_id(),
                menu.getCafe_id(),
                menu.getName(),
                menu.getDescription(),
                menu.getPrice(),
                specialDiscount
        );

        try {
            menuRepository.save(menuWithDiscount);
            logMessage("Successfully saved menu item with ID: " + menu.getItem_id());
        } catch (Exception e) {
            logMessage("Error saving menu item: " + e.getMessage());
        }
    }

    public void deleteMenuItem(Long itemId) {
        try {
            menuRepository.deleteById(itemId);
            logMessage("Successfully deleted menu item with ID: " + itemId);
        } catch (Exception e) {
            logMessage("Error deleting menu item with ID: " + itemId + ": " + e.getMessage());
        }
    }
    private void logMessage(String message) {
        // Trigger the event and notify observers
        observable.hasChanged();
        observable.notifyObservers(message);
    }
}
