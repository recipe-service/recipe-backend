package com.example.recipe.menu.domain;

import com.example.recipe.step.domain.Step;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.util.Lazy;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "menu")
    @OrderBy("stepOrder ASC")
    List<Step> steps = new ArrayList<>();
}
