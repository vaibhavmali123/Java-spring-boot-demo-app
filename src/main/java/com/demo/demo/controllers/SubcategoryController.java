package com.demo.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.dto.SubCategoryRequestDTO;
import com.demo.demo.entities.Category;
import com.demo.demo.entities.ResponseEntity;
import com.demo.demo.entities.Subcategory;
import com.demo.demo.services.SubCategoryService;

@RestController
public class SubcategoryController {

	private static final Logger logger = LogManager.getLogger(SubcategoryController.class);

    @Autowired
    SubCategoryService subCategoryService;
    
    ResponseEntity responseEntity=new ResponseEntity();

	 @PostMapping("/addSubCategory")
	    public ResponseEntity addSubCategory(@RequestBody SubCategoryRequestDTO subCategoryRequestDTO) {

	    	//logger.info("********** API getCategoryId ******** Start"+subCategoryRequestDTO.getSubCategoryName());

	    	logger.info("********** API getCategoryIdjj ******** Start"+subCategoryRequestDTO.getCategoryId());

	    	Subcategory subCategory=subCategoryService.saveSubCategories(subCategoryRequestDTO);

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


		@GetMapping("getAllSubCategories")
		public ResponseEntity getSubCategories()
		{
			
			List<Subcategory>listSubCategoryCategories=subCategoryService.getSubCategories();
			
					if(listSubCategoryCategories.size()>0) {
						
						responseEntity.setStatusCode("200");
						responseEntity.setMessage("Success");
						responseEntity.setList((ArrayList)listSubCategoryCategories);
					}
					else {
						responseEntity.setStatusCode("500");
						responseEntity.setMessage("Failed to fetch categories");
						responseEntity.setList((ArrayList)listSubCategoryCategories);
						
					}
			
			return responseEntity;
		}
		
		@GetMapping("getSubCategoriesById")
		public ResponseEntity getSubCategoriesById(@RequestParam(value = "categoryId")int categoryId)
		{
			
			List<Subcategory>listSubCategoryCategories=subCategoryService.getSubCategoriesById(categoryId);
			
					if(listSubCategoryCategories.size()>0) {
						
						responseEntity.setStatusCode("200");
						responseEntity.setMessage("Success");
						responseEntity.setList((ArrayList)listSubCategoryCategories);
					}
					else {
						responseEntity.setStatusCode("500");
						responseEntity.setMessage("Failed to fetch categories");
						responseEntity.setList((ArrayList)listSubCategoryCategories);
						
					}
			
			return responseEntity;
		}

}
