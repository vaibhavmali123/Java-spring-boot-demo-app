package com.demo.demo.controllers;

import java.util.ArrayList;import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.dto.CategoryDTO;
import com.demo.demo.dto.ResponseDTO.CategoryResponseDTO;
import com.demo.demo.entities.Category;
import com.demo.demo.entities.ResponseEntity;
import com.demo.demo.services.CategoryService;


@RestController
public class CategoryController {
	private static final Logger logger = LogManager.getLogger(OrderController.class);

    ResponseEntity responseEntity=new ResponseEntity();
    @Autowired
    CategoryService categoryService;
    
	@PostMapping("/saveCategory")
	public ResponseEntity saveCategory(@RequestBody CategoryDTO categoryReq) {
		
		try {
			logger.info("********** API saveCategory ******** Start");

	       	logger.info("********** API saveCategory req  ******** "+categoryReq.getCategoryName());

			Category category=categoryService.saveCategories(categoryReq);


			
			if (category!=null) {
				responseEntity.setStatusCode("200");
		           responseEntity.setMessage("Success");
		       	logger.info("********** API saveCategory saved  ******** "+category.getCategoryName());
	  
			}
			else {
				responseEntity.setStatusCode("504");
		           responseEntity.setMessage("Failed");    
			
			}
	    	logger.info("********** API saveCategory ******** End");

		}
		catch (Exception e) {
	    	logger.info("********** API saveCategory ******** End"+e.getMessage());
		}
		return responseEntity;
		
	}
	
	@GetMapping("getAllCategories")
	public ResponseEntity getCategories()
	{
		try {
			List<CategoryResponseDTO>listCategoryCategories=categoryService.getCategories();
			
			if(listCategoryCategories.size()>0) {
				
				responseEntity.setStatusCode("200");
				responseEntity.setMessage("Success");
				responseEntity.setList((ArrayList)listCategoryCategories);
			}
			else {
				responseEntity.setStatusCode("500");
				responseEntity.setMessage("Failed to fetch categories");
				responseEntity.setList((ArrayList)listCategoryCategories);						
			}

		}
		catch (Exception e) {
	    	logger.info("********** API getAllCategories ******** END"+e.getMessage());
			}
		
		return responseEntity;
	}

	@PostMapping("updateCategories")
public ResponseEntity updateCategories(@RequestParam(value = "categoryName")String categoryName,@RequestParam(value = "categoryId")int categoryId) {
    	logger.info("********** API updateCategories ******** START");

		try {
			
			int result=categoryService.updateCategories(categoryName,categoryId);
			
			if(result>0) {
				
				responseEntity.setStatusCode("200");
				responseEntity.setMessage("Success");
			}
			else {
				responseEntity.setStatusCode("500");
				responseEntity.setMessage("Failed to fetch categories");
			}
		}
		catch (Exception e) {
	    	logger.info("********** API updateCategories ******** END");
		}
    	logger.info("********** API updateCategories ******** END");
		return responseEntity;
	}
	@PostMapping("deleteCategory")
	public ResponseEntity deleteCategory(@RequestParam(value = "categoryId")int categoryId) {
	    	logger.info("********** API deleteCategory ******** START");

			try {
				
				categoryService.deleteCategory(categoryId);
				
				
					responseEntity.setStatusCode("200");
					responseEntity.setMessage("Success");
				
			}
			catch (Exception e) {
		    	logger.info("********** API deleteCategory ******** END");
			}
	    	logger.info("********** API deleteCategory ******** END");
			return responseEntity;
		}

}

