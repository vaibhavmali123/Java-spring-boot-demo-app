package com.demo.demo.controllers;

import java.util.List;

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
  
    @Autowired      
    CustomerService customerService;
    
    ResponseEntity responseEntity=new ResponseEntity();

    @GetMapping("/getCustomers")
    public List<Customer> getCustomers(){

        
        List<Customer>customerList=this.customerService.getAllCustomers(); 

       System.out.println("LIST LENGTH"+customerList.size()); 
        return customerList;
    }

    @PostMapping("/getCustomer")
    public Customer getCustomer(){

        return this.customerService.getCustomer(19);
    }

    @PostMapping("/saveCustomers")
    public ResponseEntity saveCustomers(@RequestBody Customer customer){

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

        return responseEntity;
    }

}
//http://localhost:8080/getCustomers?data=vaibhav