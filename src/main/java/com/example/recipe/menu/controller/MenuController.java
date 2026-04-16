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

    // 전체 메뉴 조회
    @GetMapping("/menus")
    List<Menu> getMenus(){
        return menuService.getMenus();
    }

    // 메뉴 생성
    @PostMapping("/menus")
    Menu createMenu(@RequestBody MenuCreateRequestDto menuCreateRequestDto) {
        Menu requestMenu = new Menu();
        requestMenu.setTitle(menuCreateRequestDto.getTitle());
        requestMenu.setDescription(menuCreateRequestDto.getDescription());

        return menuService.createMenu(requestMenu);
    }

    // 공부용
    // (menuId를 넣으면) 각 step의 content을 리스트로 조회
//    @GetMapping("/menus/{menuId}/steps/contents")
//    List<String> getStepContents(@PathVariable Long menuId){
//        return menuService.getStepContents(menuId);
//    }
}


