package com.mallu.foodApp_Spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mallu.foodApp_Spring.dao.FoodMenuDao;
import com.mallu.foodApp_Spring.dao.FoodOrderDao;
import com.mallu.foodApp_Spring.dao.ItemsDao;
import com.mallu.foodApp_Spring.dto.FoodMenu;
import com.mallu.foodApp_Spring.dto.FoodOrder;
import com.mallu.foodApp_Spring.dto.Items;
import com.mallu.foodApp_Spring.dto.ResponseStructure;

@Service
public class FoodOrderService {

	@Autowired
	private FoodOrderDao foodOrderDao;
	
	@Autowired
	private FoodMenuDao foodMenuDao;
	
	@Autowired
	private ItemsDao itemsDao;
	
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder){
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<FoodOrder>();
		
	
		for(Items item:foodOrder.getItems()) {
			FoodMenu foodMenu=foodMenuDao.getFoodMenuById(item.getFoodMenuId());
			item.setCost(foodMenu.getCost());
			item.setName(foodMenu.getName());
			item.setTotal(item.getCost()*item.getQuantity());
			//itemsDao.saveItems(item);
			//item.setFoodOrder(foodOrder);
		}
		
		int total=0;
		for (Items item : foodOrder.getItems()) {
			total += item.getTotal();

		}
		foodOrder.setTotal_cost(total);
		
		FoodOrder foodOrder2 =foodOrderDao.saveFoodOrder(foodOrder);
		for(Items item:foodOrder.getItems()) {
			FoodMenu foodMenu=foodMenuDao.getFoodMenuById(item.getFoodMenuId());
			item.setFoodOrder(foodOrder2);
			itemsDao.saveItems(item);
		}
		
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(foodOrder2);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(int id){
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<>();
		FoodOrder foodOrder=foodOrderDao.getFoodOrderById(id);
		if(foodOrder!=null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(foodOrder);
		return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
		}else {
			return null;
		}
	}
}
