package com.example.recipe.step.repository;

import com.example.recipe.step.domain.Step;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository<Step, Long> {
}
