package com.demo.demo.services;


import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.demo.dao.CategoryRepository;
import com.demo.demo.dao.SubCategoryRepository;
import com.demo.demo.entities.Category;
import com.demo.demo.entities.Subcategory;

@Component
public class SubCategoryService {

	private static final Logger logger = LogManager.getLogger(OrderService.class);

	@Autowired
	SubCategoryRepository subCategoryRepository;
	
	
public Subcategory saveSubCategories(Subcategory subCategoryReq) {
	
	
	subCategoryReq.setCreatedDate(new Date());

	Subcategory subCategory=subCategoryRepository.save(subCategoryReq);
	
	return subCategory;
}

}
