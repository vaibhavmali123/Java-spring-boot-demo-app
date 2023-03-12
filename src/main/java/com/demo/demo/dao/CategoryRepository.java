package com.demo.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.demo.demo.entities.Category;
import com.demo.demo.entities.Orders;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    Category findById(int id);

	
}
