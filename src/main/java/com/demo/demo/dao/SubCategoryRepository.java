package com.demo.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.demo.demo.entities.Subcategory;


public interface SubCategoryRepository extends CrudRepository<Subcategory, Integer>{

	Subcategory findById(int id);
	
}
