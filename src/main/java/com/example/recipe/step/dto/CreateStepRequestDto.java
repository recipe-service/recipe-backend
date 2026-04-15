package com.example.recipe.step.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateStepRequestDto {
    String content;
    Long menuId;
}
