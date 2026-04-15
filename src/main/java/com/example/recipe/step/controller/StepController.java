package com.example.recipe.step.controller;

import com.example.recipe.step.domain.Step;
import com.example.recipe.step.dto.CreateStepRequestDto;
import com.example.recipe.step.service.StepService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class StepController {
    StepService stepService;

    StepController(StepService stepService){
        this.stepService = stepService;
    }

    @PostMapping("/steps")
    Step createStep(CreateStepRequestDto createStepRequestDto){
        Step newStep = new Step();
        newStep.setContent(createStepRequestDto.getContent());
        newStep.setMenuId(createStepRequestDto.getMenuId());

        return stepService.createStep(newStep);

    }



}
