package com.Cockroach.service;

import com.Cockroach.model.Menu;
import com.Cockroach.repo.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepo menuRepository;

    @Autowired
    public MenuService(MenuRepo menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getAllMenuItems() {
        return menuRepository.findAll();
    }

    public List<Menu> getMenuItemsByCafe(Long cafeId) {
        return menuRepository.findByCafe_Cafe_id(cafeId);
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

        menuRepository.save(menuWithDiscount);
    }

    public void deleteMenuItem(Long itemId) {
        menuRepository.deleteById(itemId);
    }
}
