package com.mallu.foodApp_Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mallu.foodApp_Spring.dto.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer>{

}
