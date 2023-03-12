package com.demo.demo.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.demo.demo.entities.Customer;
import com.demo.demo.entities.OrderItem;
import com.demo.demo.entities.Product;

@EnableTransactionManagement
public interface ProductRepository extends CrudRepository<Product,Integer>{

	
    public Product findById(int id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value =  "UPDATE product p SET p.quantity=:quantity WHERE p.product_id=:product_id",nativeQuery = true)
    int updateProductById(@Param("product_id") int product_id,@Param("quantity") int quantity);
}
