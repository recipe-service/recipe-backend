package com.example.recipe.step.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StepRequestDto {
    private Long id;
    private Integer stepNumber;
    private String content;
}
