package com.example.recipe.step.service;

import com.example.recipe.menu.domain.Menu;
import com.example.recipe.menu.repository.MenuRepository;
import com.example.recipe.step.domain.Step;
import com.example.recipe.step.dto.StepRequestDto;
import com.example.recipe.step.dto.StepResponseDto;
import com.example.recipe.step.repository.StepRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

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

    @Transactional
    public List<StepResponseDto> updateSteps(Long menuId, List<StepRequestDto> requestDtos){
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));

        // 동일 menuId에 해당하는 steps 전부 지우기
        stepRepository.deleteAllByMenuId(menuId);

        List<Step> requestSteps = requestDtos.stream().map(stepRequestDto ->
                new Step(
                        stepRequestDto.getStepNumber(),
                        stepRequestDto.getContent(),
                        menu
                )).toList();

        List<Step> responseSteps = stepRepository.saveAll(requestSteps);
        return responseSteps.stream().map(step ->
                new StepResponseDto(step.getId(), step.getStepNumber(), step.getContent())
        ).toList();
    }
}
