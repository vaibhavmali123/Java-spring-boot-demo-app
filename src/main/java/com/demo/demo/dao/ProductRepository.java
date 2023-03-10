package com.demo.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.demo.demo.entities.Customer;
import com.demo.demo.entities.Product;

public interface ProductRepository extends CrudRepository<Product,Integer>{

	
    public Product findById(int id);

}
