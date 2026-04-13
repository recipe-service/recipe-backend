package com.example.recipe.menu.service;

import com.example.recipe.menu.domain.Menu;
import com.example.recipe.menu.dto.MenuCreateRequestDto;
import com.example.recipe.menu.repository.MenuRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    MenuRepository menuRepository;

    MenuService(MenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }

    public List<Menu> getMenus() {
        return menuRepository.findAll();
    }

    public Menu createMenu(Menu requestMenu) {

        return menuRepository.save(requestMenu);
    }
}
