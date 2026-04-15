package com.example.recipe.step.service;

import com.example.recipe.menu.repository.MenuRepository;
import com.example.recipe.step.domain.Step;
import com.example.recipe.step.repository.StepRepository;
import org.springframework.stereotype.Service;

@Service
public class StepService {
    StepRepository stepRepository;
    MenuRepository menuRepository;

    StepService(StepRepository stepRepository, MenuRepository menuRepository){
        this.stepRepository = stepRepository;
        this.menuRepository = menuRepository;
    }

    public Step createStep(Step requestStep){
        // menuId 존재하는지 확인하기
        if(!menuRepository.existsById(requestStep.getMenuId())){
            throw new IllegalArgumentException("존재하지 않는 메뉴입니다.");
        }

        // 없으면 에러, 있으면 생성
        return stepRepository.save(requestStep);
    }

}
