package com.demo.demo.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.demo.dao.CategoryRepository;
import com.demo.demo.entities.Category;

@Component
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	
public Category saveCategories(Category categoryReq) {
	
	
	categoryReq.setCreatedDate(new Date());
	Category category=categoryRepository.save(categoryReq);
	
	return category;
}
}
