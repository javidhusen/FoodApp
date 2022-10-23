package com.mallu.foodApp_Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mallu.foodApp_Spring.dto.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer> {

}
