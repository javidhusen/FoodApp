package com.mallu.foodApp_Spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mallu.foodApp_Spring.dto.FoodMenu;
import com.mallu.foodApp_Spring.dto.ResponseStructure;
import com.mallu.foodApp_Spring.service.FoodMenuService;

@RestController
@RequestMapping("/foodmenu")
public class FoodMenuController {

	@Autowired
	private FoodMenuService foodMenuService;

	@PostMapping
	public ResponseEntity<ResponseStructure<FoodMenu>> saveFoodMenu(@RequestBody FoodMenu foodMenu) {
		return foodMenuService.saveFoodMenu(foodMenu);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<FoodMenu>> getFoodMenuById(@PathVariable int id) {
		return foodMenuService.getFoodMenuById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseEntity<FoodMenu>> deleteFoodMenuById(@PathVariable int id) {
		return foodMenuService.deleteFoodMenuById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<FoodMenu>> updateFoodMenu(FoodMenu foodMenu){
		return foodMenuService.updateFoodMenu(foodMenu);
	}
}
