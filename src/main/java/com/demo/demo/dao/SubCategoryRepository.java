package com.demo.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.demo.entities.Orders;
import com.demo.demo.entities.Subcategory;


public interface SubCategoryRepository extends CrudRepository<Subcategory, Integer>{

	Subcategory findById(int id);
	
	 @Query(value = "SELECT * FROM sub_category WHERE category_id=:categoryId",nativeQuery = true)
		List<Subcategory>findAllBycategoryId(@Param("categoryId") int categoryId);


	

}
