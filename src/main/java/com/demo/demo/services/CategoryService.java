package com.demo.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.demo.dao.CategoryRepository;
import com.demo.demo.dto.ResponseDTO.CategoryResponseDTO;
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

public List<CategoryResponseDTO> getCategories() {
	
	List<Category>listCategoryCategories=(List<Category>) categoryRepository.findAll();
	List<CategoryResponseDTO>categoryListResponseDTO=new ArrayList<CategoryResponseDTO>();
	
	
	for(Category category:listCategoryCategories) {
		
		CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO();
		
		categoryResponseDTO.setCategoryId(category.getCategoryId());

		categoryResponseDTO.setCategoryName(category.getCategoryName());

		categoryResponseDTO.setSequence(category.getSequence());
		
		categoryListResponseDTO.add(categoryResponseDTO);
	}
	return categoryListResponseDTO;
}
}
