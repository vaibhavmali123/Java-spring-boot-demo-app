package com.demo.demo.dao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.demo.entities.Orders;
import java.util.List;



public interface OrderRepository extends CrudRepository<Orders,Integer>{
    
    Orders findById(int id);
    
    
    @Query(value = "SELECT * FROM ordertable WHERE customer_id=:customer_id",nativeQuery = true)
    List<Orders> findByCustomerId(@Param("customer_id") int customer_id);

}
