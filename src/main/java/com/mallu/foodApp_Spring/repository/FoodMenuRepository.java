package com.mallu.foodApp_Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mallu.foodApp_Spring.dto.FoodMenu;

public interface FoodMenuRepository extends JpaRepository<FoodMenu, Integer> {
	
}
