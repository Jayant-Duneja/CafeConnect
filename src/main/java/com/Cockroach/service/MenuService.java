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
        menuRepository.save(menu);
    }

    public void deleteMenuItem(Long itemId) {
        menuRepository.deleteById(itemId);
    }
}
