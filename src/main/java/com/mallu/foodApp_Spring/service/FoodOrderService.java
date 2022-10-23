package com.mallu.foodApp_Spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mallu.foodApp_Spring.dao.FoodOrderDao;
import com.mallu.foodApp_Spring.dto.FoodOrder;
import com.mallu.foodApp_Spring.dto.ResponseStructure;

@Service
public class FoodOrderService {

	@Autowired
	private FoodOrderDao foodOrderDao;
	
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder){
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<FoodOrder>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(foodOrderDao.saveFoodOrder(foodOrder));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}
}
