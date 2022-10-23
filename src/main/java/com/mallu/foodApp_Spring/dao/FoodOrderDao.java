package com.mallu.foodApp_Spring.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mallu.foodApp_Spring.dto.FoodOrder;
import com.mallu.foodApp_Spring.repository.FoodOrderRepository;

@Repository
public class FoodOrderDao {

	@Autowired
	private FoodOrderRepository foodOrderRepository;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return foodOrderRepository.save(foodOrder);
	}
	
	public FoodOrder getFoodOrderById(int id) {
		Optional<FoodOrder> optional=foodOrderRepository.findById(id);
		if(optional!=null) {
		return	optional.get();
		}else {
			return null;
		}
	}
	
	public String deleteOrderById(int id) {
		Optional<FoodOrder> optional=foodOrderRepository.findById(id);
		if(optional!=null) {
				foodOrderRepository.delete(optional.get());
				return "Deleted";
			}else {
				return null;
			}
	}
}
