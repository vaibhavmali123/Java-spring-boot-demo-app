package com.demo.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.demo.demo.entities.Orders;
import com.demo.demo.entities.Subcategory;


public interface SubCategoryRepository extends CrudRepository<Subcategory, Integer>{

	Subcategory findById(int id);
	
	 @Query(value = "SELECT * FROM sub_category WHERE category_id=:categoryId",nativeQuery = true)
		List<Subcategory>findAllBycategoryId(@Param("categoryId") int categoryId);

	    @Modifying(clearAutomatically = true)
	    @Transactional
	    @Query(value =  "UPDATE sub_category c SET c.sub_category_name=:subCategory_name WHERE c.sub_category_id=:subCategory_id",nativeQuery = true)
	    int updateSubCategoryById(@Param("subCategory_id") int subCategory_id,@Param("subCategory_name") String subCategory_name);


}
