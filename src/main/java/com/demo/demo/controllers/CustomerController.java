package com.demo.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.entities.Customer;
import com.demo.demo.entities.ResponseEntity;
import com.demo.demo.services.CustomerService;


@RestController
public class CustomerController {
	
	private static final Logger logger = LogManager.getLogger(OrderController.class);

    @Autowired      
    CustomerService customerService;
    
    ResponseEntity responseEntity=new ResponseEntity();

    @GetMapping("/getCustomers")
    public ResponseEntity getCustomers(){
    	logger.info("********** API  getCustomers ******** Start");

        List<Customer>customerList=this.customerService.getAllCustomers(); 

        if(customerList.size()>0){

            responseEntity.setStatusCode("200");
            responseEntity.setMessage("Success");
            responseEntity.setList((ArrayList) customerList); 
            
        	logger.info("**********API getAllOrders  END ********"+customerList.size());

        }
        logger.info("********** API  getCustomers ******** End"+customerList.size());

        return responseEntity;
    }

    @PostMapping("/getCustomer")
    public Customer getCustomer(){

        return this.customerService.getCustomer(19);
    }

    @PostMapping("/saveCustomers")
    public ResponseEntity saveCustomers(@RequestBody Customer customer){
    	logger.info("********** API  saveCustomers ******** Start");

        if(customer!=null){
            customerService.addCustomer(customer);

         responseEntity.setStatusCode("200");
         responseEntity.setMessage("Success");
         
        }
        else
        {
            responseEntity.setStatusCode("500");
            responseEntity.setMessage("Something Went Wrong");   
            
        }
    	logger.info("********** API  saveCustomers ******** End");

        return responseEntity;
    }

}
//http://localhost:8080/getCustomers?data=vaibhav