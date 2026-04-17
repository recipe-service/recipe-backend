package com.example.recipe.step.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StepResponseDto {
    private Long id;
    private Integer stepNumber;
    private String content;
}