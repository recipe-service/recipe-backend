package com.example.recipe.step.domain;

import com.example.recipe.menu.domain.Menu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

//    private Long menuId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    Menu menu;
}
