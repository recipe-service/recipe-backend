package com.example.recipe.menu.controller;

import com.example.recipe.menu.domain.Menu;
import com.example.recipe.menu.dto.MenuCreateRequestDto;
import com.example.recipe.menu.dto.MenuResponseDto;
import com.example.recipe.menu.dto.MenusResponseDto;
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
    MenusResponseDto getMenus(){
        List<Menu> menus = menuService.getMenus();
        // List<Menu> -> List<MenuResponseDto>
        List<MenuResponseDto> menuDtos = menus.stream()
                .map(menu -> new MenuResponseDto(menu.getId(), menu.getTitle(), menu.getDescription()))
                .toList();
        return new MenusResponseDto(menuDtos);
    }

    // 메뉴 생성
    @PostMapping("/menus")
    MenuResponseDto createMenu(@RequestBody MenuCreateRequestDto menuCreateRequestDto) {
        Menu requestMenu = new Menu();
        requestMenu.setTitle(menuCreateRequestDto.getTitle());
        requestMenu.setDescription(menuCreateRequestDto.getDescription());

        Menu resultMenu = menuService.createMenu(requestMenu);
        return new MenuResponseDto(resultMenu.getId(), resultMenu.getTitle(), resultMenu.getDescription());
    }

    // 공부용
    // (menuId를 넣으면) 각 step의 content을 리스트로 조회
//    @GetMapping("/menus/{menuId}/steps/contents")
//    List<String> getStepContents(@PathVariable Long menuId){
//        return menuService.getStepContents(menuId);
//    }
}


