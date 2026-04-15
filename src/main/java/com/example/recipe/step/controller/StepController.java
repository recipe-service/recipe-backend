package com.example.recipe.step.controller;

import com.example.recipe.step.domain.Step;
import com.example.recipe.step.dto.CreateStepRequestDto;
import com.example.recipe.step.service.StepService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class StepController {
    StepService stepService;

    StepController(StepService stepService){
        this.stepService = stepService;
    }

    // 미완성
//    @PostMapping("/steps")
//    Step createStep(CreateStepRequestDto createStepRequestDto){
//        Step newStep = new Step();
//        newStep.setContent(createStepRequestDto.getContent());
//        newStep.setMenuId(createStepRequestDto.getMenuId());
//
//        return stepService.createStep(newStep);
//    }

    // 공부용
//    @GetMapping("/steps/menus/titles")
//    List<String> getMenuTitlesOfSteps(){
//        return stepService.getMenuTitlesOfSteps();
//    }

    // (menuId에 따른) steps 조회
    // steps/menu/{menuId}
    @GetMapping("steps/menu/{menuId}")
    List<Step> getSteps(@PathVariable Long menuId){
        return stepService.getSteps(menuId);
    }

}
