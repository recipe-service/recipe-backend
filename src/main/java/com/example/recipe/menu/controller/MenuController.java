package com.example.recipe.menu.controller;

import com.example.recipe.menu.domain.Menu;
import com.example.recipe.menu.dto.MenusResponseDto;
import com.example.recipe.menu.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class MenuController {
    MenuService menuService;

    MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    @GetMapping("/menus")
    List<Menu> getMenus(){
        return menuService.getMenus();
    }
}


