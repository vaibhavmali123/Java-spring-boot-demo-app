package com.demo.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.demo.dao.CategoryRepository;
import com.demo.demo.entities.Category;

@Component
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	
public Category saveCategories(Category categoryReq) {
	
	
	Category category=categoryRepository.save(categoryReq);
	
	return category;
}
}
