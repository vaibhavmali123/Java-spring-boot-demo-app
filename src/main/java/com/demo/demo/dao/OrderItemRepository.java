package com.demo.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.demo.entities.Customer;
import com.demo.demo.entities.OrderItem;
import com.demo.demo.entities.Orders;

public interface OrderItemRepository extends CrudRepository<OrderItem,Integer>{

    public OrderItem findById(int id);

    @Query(value = "SELECT * FROM order_item WHERE order_id=:order_id",nativeQuery = true)
    OrderItem findByOrderId(@Param("order_id") int order_id);
}
