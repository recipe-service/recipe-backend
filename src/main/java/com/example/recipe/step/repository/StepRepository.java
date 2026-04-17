package com.example.recipe.step.repository;

import com.example.recipe.step.domain.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StepRepository extends JpaRepository<Step, Long> {
    List<Step> findAllByMenuId(Long menuId);

    void deleteAllByMenuId(Long menuId);
}
