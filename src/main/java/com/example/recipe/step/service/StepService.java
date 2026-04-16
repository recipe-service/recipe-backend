package com.example.recipe.step.service;

import com.example.recipe.menu.domain.Menu;
import com.example.recipe.menu.repository.MenuRepository;
import com.example.recipe.step.domain.Step;
import com.example.recipe.step.dto.CreateStepRequestDto;
import com.example.recipe.step.repository.StepRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StepService {
    StepRepository stepRepository;
    MenuRepository menuRepository;

    StepService(StepRepository stepRepository, MenuRepository menuRepository){
        this.stepRepository = stepRepository;
        this.menuRepository = menuRepository;
    }

    public List<String> getMenuTitlesOfSteps(){
        // 전체 steps의 menu 들고오기
        List<Step> steps = stepRepository.findAll();

        // steps -> menu.title로 매핑하기
        return steps.stream()
                .map(step -> step.getMenu().getTitle())
                .toList();
    }

    public List<Step> getSteps(Long menuId){
        return stepRepository.findAllByMenuId(menuId);
    }

    // TODO: Reordering 전용 메서드 만들기
//    public Step createStep(Long menuId, CreateStepRequestDto createStepRequestDto){
//        Menu menu = menuRepository.findById(menuId)
//                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));
//
//        // "밀어내기" 로직
//        // (중복/초과 stepOrder 존재 -> 나머지 뒤로 밀리기)
//        stepRepository.updateStepOrders(menuId, createStepRequestDto.getStepOrder());
//
//        Step newStep = new Step();
//        newStep.setContent(createStepRequestDto.getContent());
//        newStep.setStepOrder(createStepRequestDto.getStepOrder());
//        newStep.setMenu(menu);
//
//        return stepRepository.save(newStep);
//    }
}
