package com.example.recipe.menu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MenuResponseDto {
    private Long id;
    private String title;
    private String description;

    public MenuResponseDto(Long id, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
