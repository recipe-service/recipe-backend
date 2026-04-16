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

    // 공부용
//    @GetMapping("/steps/menus/titles")
//    List<String> getMenuTitlesOfSteps(){
//        return stepService.getMenuTitlesOfSteps();
//    }

    // TODO: OrderByStepOrderAsc
    // (menuId에 따른) Steps 조회
    // steps/menu/{menuId}
    @GetMapping("/steps/menu/{menuId}")
    List<Step> getSteps(@PathVariable Long menuId){
        return stepService.getSteps(menuId);
    }

    // Step 생성
//    @PostMapping("/steps/menu/{menuId}")
//    Step createStep(@PathVariable Long menuId, @RequestBody CreateStepRequestDto createStepRequestDto){
//        return stepService.createStep(menuId, createStepRequestDto);
//    }

    // 순서 변경 api

}
