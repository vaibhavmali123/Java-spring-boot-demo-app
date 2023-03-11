package com.demo.demo.controllers;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.dto.OrderDTO;
import com.demo.demo.dto.OrderItemDTO;
import com.demo.demo.dto.OrderListDto;
import com.demo.demo.dto.OrderRequestDTO;
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

        System.out.println("********** API getAllOrders ******** Start");

        List<OrderDTO>listOrders=orderService.getAllOrders();
        if(listOrders.size()>0){
          
            responseEntity.setStatusCode("200");
            responseEntity.setMessage("Success");
            responseEntity.setList((ArrayList) listOrders);  
            System.out.println("********** API getAllOrders Step 1 IF ********"+listOrders.size());

            }
            else{
                responseEntity.setStatusCode("500");
                responseEntity.setMessage("No Orders Found");
                responseEntity.setList(null);
                System.out.println("********** API getAllOrders Step 1 Else no orders found********");

            }
        return  responseEntity;
    }
    
    @PostMapping("order/{customerId}/saveOrder/{productId}")
    public ResponseEntity saveOrder(@PathVariable(value = "customerId")int customerId,
    		@PathVariable(value = "productId")int productId,
    		@RequestBody OrderListDto orders){
        //System.out.println("SSSSSSSSMMM   idddd"+orders.getProduct().getProductId());

    	System.out.println("SSSSSSSSMMM   idddd"+orders.getOrderDTOList().size());

    	System.out.println("SSSSSSSSMMM   idddd"+orders.getOrderDTOList().get(0).getDate());

    	System.out.println("SSSSSSSSMMM   idddd"+orders.getOrderDTOList().get(0).getPrice());

        orderService.saveOrders(orders,customerId);
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
    
    @GetMapping("/getBill/{customerId}")
    public ResponseEntity getBill(@PathVariable(value = "customerId")int customerId) {
    	
		List<OrderItemDTO>listResponse=orderService.getBill(customerId);
    	
		 if(listResponse.size()>0){
	          
	            responseEntity.setStatusCode("200");
	            responseEntity.setMessage("Success");
	            responseEntity.setList((ArrayList) listResponse);  
	            System.out.println("********** API getBill Step 1 IF ********"+listResponse.size());

	            }
	            else{
	                responseEntity.setStatusCode("500");
	                responseEntity.setMessage("No Orders Bills Found");
	                responseEntity.setList(null);
	                System.out.println("********** API getBill Step 1 Else no orders found********");

	            }
    	return responseEntity;
    }
}
