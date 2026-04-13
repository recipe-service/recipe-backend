package com.example.recipe.menu.controller;

import com.example.recipe.menu.domain.Menu;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuController {
    @GetMapping("/menus")
    List<Menu> getMenus(){
        Menu menu1 = new Menu();
        Menu menu2 = new Menu();
        menu1.id = 1L;
        menu1.title = "pasta";
        menu1.description = "italian dish";
        menu2.id = 2L;
        menu2.title = "burger";
        menu2.description = "US dish";
        List<Menu> totalMenu = new ArrayList<>();
        totalMenu.add(menu1);
        totalMenu.add(menu2);

        return totalMenu;
    }
}


