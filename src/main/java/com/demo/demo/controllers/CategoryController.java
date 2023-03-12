package com.demo.demo.controllers;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.entities.Category;
import com.demo.demo.entities.ResponseEntity;
import com.demo.demo.services.CategoryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CategoryController {
	private static final Logger logger = LogManager.getLogger(OrderController.class);

    ResponseEntity responseEntity=new ResponseEntity();
    @Autowired
    CategoryService categoryService;
    
	@PostMapping("/saveCategory")
	public ResponseEntity saveCategory(@RequestBody Category categoryReq) {
		
		Category category=categoryService.saveCategories(categoryReq);
		
		if (category!=null) {
			responseEntity.setStatusCode("200");
	           responseEntity.setMessage("Success");
	            
		}
		else {
			responseEntity.setStatusCode("504");
	           responseEntity.setMessage("Failed");
	            
		
		}
		   
		return responseEntity;
		
	}
	
}
