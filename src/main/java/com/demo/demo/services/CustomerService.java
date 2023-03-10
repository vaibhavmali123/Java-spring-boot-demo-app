package com.demo.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.demo.controllers.CustomerController;
import com.demo.demo.entities.Customer;
import com.demo.demo.dao.CustomerRepository;

@Component
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){

        List<Customer>customersList=(List<Customer>) this   .customerRepository.findAll();
        return  customersList;
    }

    public Customer getCustomer(int id){

        Customer customer=this.customerRepository.findById(id);

        return customer;
    }
    public Customer addCustomer(Customer customer){

        this.customerRepository.save(customer);
        
        return customer;
    }

}
