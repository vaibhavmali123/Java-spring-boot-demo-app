package com.demo.demo.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.entities.Category;
import com.demo.demo.entities.ResponseEntity;
import com.demo.demo.entities.Subcategory;
import com.demo.demo.services.SubCategoryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class SubCategoryController {
	private static final Logger logger = LogManager.getLogger(OrderController.class);

    ResponseEntity responseEntity=new ResponseEntity();

    @Autowired
    SubCategoryService subCategoryService;
    
    @PostMapping("/addSubCategory")
    public ResponseEntity addSubCategory(@RequestBody Subcategory subCategoryReq) {
    	
    	Subcategory subCategory=subCategoryService.saveSubCategories(subCategoryReq);
    	
		if (subCategory!=null) {
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
