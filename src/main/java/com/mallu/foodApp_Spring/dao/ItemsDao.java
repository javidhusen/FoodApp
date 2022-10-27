package com.mallu.foodApp_Spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mallu.foodApp_Spring.dto.Items;
import com.mallu.foodApp_Spring.repository.ItemsRepository;

@Repository
public class ItemsDao {

	@Autowired
	private ItemsRepository itemsRepository;
	
	public Items saveItems(Items items) {
		return itemsRepository.save(items);
	}
}
