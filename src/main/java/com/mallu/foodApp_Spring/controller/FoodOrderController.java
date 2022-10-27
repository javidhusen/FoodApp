package com.mallu.foodApp_Spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mallu.foodApp_Spring.dto.FoodOrder;
import com.mallu.foodApp_Spring.dto.ResponseStructure;
import com.mallu.foodApp_Spring.service.FoodOrderService;

@RestController
@RequestMapping("/foodorder")
public class FoodOrderController {

	@Autowired
	private FoodOrderService foodOrderService;
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodOrder){
		return foodOrderService.saveFoodOrder(foodOrder);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(@PathVariable int id){
		return foodOrderService.getFoodOrderById(id);
	}
}
