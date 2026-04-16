package com.example.recipe.step.repository;

import com.example.recipe.step.domain.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StepRepository extends JpaRepository<Step, Long> {
    List<Step> findAllByMenuId(Long menuId);

    // 조건: (1) 같은 메뉴 아이디에 대하여, (2) stepOrder가 같거나 더 클 때
//    @Query("""
//
//            """)
//    void updateStepOrders(Long menuId, Integer stepOrder);
}
