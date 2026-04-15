package com.example.recipe.menu.service;

import com.example.recipe.menu.domain.Menu;
import com.example.recipe.menu.dto.MenuCreateRequestDto;
import com.example.recipe.menu.repository.MenuRepository;
import com.example.recipe.step.domain.Step;
import com.example.recipe.step.repository.StepRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    MenuRepository menuRepository;
    StepRepository stepRepository;

    MenuService(MenuRepository menuRepository, StepRepository stepRepository){
        this.menuRepository = menuRepository;
        this.stepRepository = stepRepository;
    }

    public List<Menu> getMenus() {
        return menuRepository.findAll();
    }

    public Menu createMenu(Menu requestMenu) {

        return menuRepository.save(requestMenu);
    }

    public List<Step> getSteps(Long menuId){
        List<Step> steps = stepRepository.findAll();

        return steps.stream()
                .filter(step -> step.getMenuId().equals(menuId))
                .toList();
    }
}
