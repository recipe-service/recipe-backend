package com.example.recipe.menu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class MenusResponseDto {
    private List<MenuResponseDto> menus;

    public MenusResponseDto(List<MenuResponseDto> menus) {
        this.menus = menus;
    }
}
