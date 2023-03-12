package com.demo.demo.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.demo.controllers.CustomerController;
import com.demo.demo.controllers.OrderController;
import com.demo.demo.entities.Customer;
import com.demo.demo.dao.CustomerRepository;

@Component
public class CustomerService {
	private static final Logger logger = LogManager.getLogger(OrderController.class);

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
    	
    	logger.info("**********  getAllCustomers ******** Start");

        List<Customer>customersList=(List<Customer>) this   .customerRepository.findAll();
        
    	logger.info("********** getAllCustomers ******** End");

        return  customersList;
    }

    public Customer getCustomer(int id){
    	logger.info("**********  getCustomer ******** Start");

        Customer customer=this.customerRepository.findById(id);
    	logger.info("********** getCustomer ******** Start");
        return customer;
    }
    public Customer addCustomer(Customer customer){
    	logger.info("**********  addCustomer ******** Start");

        this.customerRepository.save(customer);
    	logger.info("********** addCustomer ******** Start");

        return customer;
    }

}
