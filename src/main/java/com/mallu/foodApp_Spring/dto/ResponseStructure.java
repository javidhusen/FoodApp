package com.mallu.foodApp_Spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStructure<T> {

	private int status;
	private String message;
	private T data;
	
}
