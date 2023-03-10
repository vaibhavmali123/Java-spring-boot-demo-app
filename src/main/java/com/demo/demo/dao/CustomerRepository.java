package com.demo.demo.dao;
import org.springframework.data.repository.CrudRepository;

import com.demo.demo.entities.Customer;


public interface CustomerRepository extends CrudRepository<Customer,Integer>
{

    public Customer findById(int id);
}
