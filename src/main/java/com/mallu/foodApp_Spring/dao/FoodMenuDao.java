package com.mallu.foodApp_Spring.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mallu.foodApp_Spring.dto.FoodMenu;
import com.mallu.foodApp_Spring.repository.FoodMenuRepository;

@Repository
public class FoodMenuDao {

	@Autowired
	private FoodMenuRepository foodRepository;
	
	public FoodMenu saveFoodmenu(FoodMenu foodMenu) {
		return foodRepository.save(foodMenu);
	}
	
	public FoodMenu getFoodMenuById(int id) {
		Optional<FoodMenu> optional=foodRepository.findById(id);
		if(optional!=null) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public String deleteFoodMenuById(int id) {
		Optional<FoodMenu> optional=foodRepository.findById(id);
		if(optional!=null) {
			foodRepository.delete(optional.get());
			return "Deleted";
		}else {
			return "Id not found";
		}
	}
}
