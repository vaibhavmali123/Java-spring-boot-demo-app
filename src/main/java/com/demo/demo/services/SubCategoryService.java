package com.demo.demo.services;


import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.demo.controllers.OrderController;
import com.demo.demo.dao.CategoryRepository;
import com.demo.demo.dao.SubCategoryRepository;
import com.demo.demo.dto.SubCategoryRequestDTO;
import com.demo.demo.entities.Category;
import com.demo.demo.entities.Subcategory;

@Component
public class SubCategoryService {

	private static final Logger logger = LogManager.getLogger(OrderService.class);

	@Autowired
	SubCategoryRepository subCategoryRepository;

	@Autowired
	CategoryRepository categoryRepository;

	
public Subcategory saveSubCategories(SubCategoryRequestDTO subCategoryRequestDTO) {
	

	
	Category category=categoryRepository.findById(subCategoryRequestDTO.getCategoryId());

	Subcategory subcategory=new Subcategory();
	
	subcategory.setCategory(category);
	logger.info("********** API getAllOrders ******** Start"+category.getCategoryId());

	
	 subcategory.setActive(subCategoryRequestDTO.isActive());
	 subcategory.setSubCategoryName(subCategoryRequestDTO.getSubCategoryName());
	 subcategory.setSequence(subCategoryRequestDTO.getSequence());
	 
	subcategory.setCreatedDate(new Date());

	Subcategory subCategory=subCategoryRepository.save(subcategory);
	
	return subCategory;
}


public List<Subcategory> getSubCategories() {
	
	List<Subcategory>listSubCategoryCategories=(List<Subcategory>) subCategoryRepository.findAll();
	
	return listSubCategoryCategories;
}

public List<Subcategory> getSubCategoriesById(int categoryId) {
	
	List<Subcategory>listSubCategoryCategories=subCategoryRepository.findAllBycategoryId(categoryId);
	
	return listSubCategoryCategories;
}

}
