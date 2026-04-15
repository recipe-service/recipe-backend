package com.example.recipe.menu.controller;

import com.example.recipe.menu.domain.Menu;
import com.example.recipe.menu.dto.MenuCreateRequestDto;
import com.example.recipe.menu.service.MenuService;
import com.example.recipe.step.domain.Step;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/menus")
    Menu createMenu(@RequestBody MenuCreateRequestDto menuCreateRequestDto) {
        Menu requestMenu = new Menu();
        requestMenu.setTitle(menuCreateRequestDto.getTitle());
        requestMenu.setDescription(menuCreateRequestDto.getDescription());

        return menuService.createMenu(requestMenu);
    }

    @GetMapping("/menus/{menuId}/steps")
    List<Step> getSteps(@PathVariable Long menuId){
        return menuService.getSteps(menuId);
    }

}


