package com.demo.demo.dao;
import org.springframework.data.repository.CrudRepository;
import com.demo.demo.entities.Orders;
import java.util.List;



public interface OrderRepository extends CrudRepository<Orders,Integer>{
    
    Orders findById(int id);
    

}
