package com.demo.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.demo.entities.Customer;
import com.demo.demo.entities.OrderItem;
import com.demo.demo.entities.ProductAudit;

public interface ProductAuditRepository extends CrudRepository<ProductAudit, Integer>{


	@Query(value = "SELECT * FROM productaudit WHERE product_id=product_id order BY updated_date DESC LIMIT 1",nativeQuery = true)
	ProductAudit findByProductId(@Param("product_id") int product_id);
    
}
