package com.demo.demo.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.demo.demo.entities.Category;
import com.demo.demo.entities.Orders;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    Category findById(int id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value =  "UPDATE category c SET c.category_name=:category_name WHERE c.category_id=:category_id",nativeQuery = true)
    int updateCategoryById(@Param("category_id") int category_id,@Param("category_name") String category_name);

}
