package com.demo.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.demo.dao.CategoryRepository;
import com.demo.demo.dto.CategoryDTO;
import com.demo.demo.dto.ResponseDTO.CategoryResponseDTO;
import com.demo.demo.entities.Category;

@Component
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	
public Category saveCategories(CategoryDTO categoryReq) {
	
	Category categoryObj=new Category();
	
	categoryObj.setCategoryName(categoryReq.getCategoryName());
	categoryObj.setSequence(categoryReq.getSequence());
	categoryObj.setCreatedDate(new Date());
	categoryObj.setActive(true);
	
	//categoryReq.setCreatedDate(new Date());
	Category category=categoryRepository.save(categoryObj);
	
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

public int updateCategories(String categoryName,int categoryId) {

	int result=categoryRepository.updateCategoryById(categoryId, categoryName);

return result;
}

@Transactional
public void deleteCategory(int categoryId) {

	 categoryRepository.deleteById(categoryId);

}
}
