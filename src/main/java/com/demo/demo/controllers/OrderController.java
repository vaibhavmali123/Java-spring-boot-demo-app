package com.demo.demo.controllers;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.demo.demo.entities.Orders;
import com.demo.demo.entities.Product;
import com.demo.demo.entities.ResponseEntity;
import com.demo.demo.services.OrderService;

@RestController
public class OrderController {

    @Autowired 
    OrderService orderService;   
    
    ResponseEntity responseEntity=new ResponseEntity();

    @GetMapping("/getAllOrders")
    public ResponseEntity getAllOrders(){

        List<Orders>listOrders=orderService.getAllOrders();
        if(listOrders.size()>0){
          
            responseEntity.setStatusCode("200");
            responseEntity.setMessage("Success");
            responseEntity.setList((ArrayList) listOrders);   
            }
            else{
                responseEntity.setStatusCode("500");
                responseEntity.setMessage("No Orders Found");
                responseEntity.setList(null);;   
            }
        return  responseEntity;
    }
    
    @PostMapping("order/{customerId}/saveOrder/{productId}")
    public ResponseEntity saveOrder(@PathVariable(value = "customerId")int customerId,
    		@PathVariable(value = "productId")int productId,
    		@RequestBody Orders orders){
        //System.out.println("SSSSSSSSMMM   idddd"+orders.getProduct().getProductId());

        orderService.saveOrders(orders,customerId,productId);
        responseEntity.setStatusCode("200");
        responseEntity.setMessage("Success");
        
        
        return responseEntity;
    }
    
    @PostMapping("/saveProduct")
    public ResponseEntity saveProduct(@RequestBody Product product){

        orderService.saveProduct(product);
        responseEntity.setStatusCode("200");
        responseEntity.setMessage("Success");
        
        return responseEntity;
    }
}
