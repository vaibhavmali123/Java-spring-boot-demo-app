package com.demo.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.demo.demo.entities.Customer;
import com.demo.demo.entities.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem,Integer>{

    public Customer findById(int id);

}
