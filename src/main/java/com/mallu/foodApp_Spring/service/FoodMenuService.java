package com.mallu.foodApp_Spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mallu.foodApp_Spring.dao.FoodMenuDao;
import com.mallu.foodApp_Spring.dto.FoodMenu;
import com.mallu.foodApp_Spring.dto.ResponseStructure;

@Service
public class FoodMenuService {

	@Autowired
	private FoodMenuDao foodMenuDao;

	public ResponseEntity<ResponseStructure<FoodMenu>> saveFoodMenu(FoodMenu foodMenu) {
		ResponseStructure<FoodMenu> responseStructure = new ResponseStructure<FoodMenu>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(foodMenuDao.saveFoodmenu(foodMenu));
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<FoodMenu>> getFoodMenuById(int id) {
		ResponseStructure<FoodMenu> responseStructure = new ResponseStructure<FoodMenu>();
		FoodMenu foodMenu = foodMenuDao.getFoodMenuById(id);
		if (foodMenu != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(foodMenu);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			return null;
		}
	}

	public ResponseEntity<ResponseEntity<FoodMenu>> deleteFoodMenuById(int id) {
		ResponseStructure<FoodMenu> responseStructure = new ResponseStructure<>();
		FoodMenu foodMenu = foodMenuDao.getFoodMenuById(id);
		if (foodMenu != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted Successfully");
			responseStructure.setData(foodMenu);
			return new ResponseEntity<ResponseEntity<FoodMenu>>(HttpStatus.OK);
		} else {
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<FoodMenu>> updateFoodMenu(FoodMenu foodMenu) {
		ResponseStructure<FoodMenu> responseStructure = new ResponseStructure<FoodMenu>();
		FoodMenu foodMenu1 = foodMenuDao.getFoodMenuById(foodMenu.getId());
		if (foodMenu1 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(foodMenuDao.saveFoodmenu(foodMenu));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			return null;
		}
	}
}
