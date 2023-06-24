package com.demo.demo.controllers;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.demo.demo.dto.ProductRequestDTO;
import com.demo.demo.dto.SubCategoryRequestDTO;
import com.demo.demo.entities.Orders;
import com.demo.demo.entities.Product;
import com.demo.demo.entities.ResponseEntity;
import com.demo.demo.entities.Subcategory;
import com.demo.demo.services.OrderService;
import com.demo.demo.services.SubCategoryService;

@RestController
public class OrderController {

	private static final Logger logger = LogManager.getLogger(OrderController.class);

    @Autowired 
    OrderService orderService;   
    
    @Autowired
    SubCategoryService subCategoryService;

    ResponseEntity responseEntity=new ResponseEntity();

    @GetMapping("/getAllOrders")
    public ResponseEntity getAllOrders(){

    	logger.info("********** API getAllOrders ******** Start");

        List<OrderDTO>listOrders=orderService.getAllOrders();
        if(listOrders.size()>0){
          
            responseEntity.setStatusCode("200");
            responseEntity.setMessage("Success");
            responseEntity.setList((ArrayList) listOrders); 
            
        	logger.info("**********API getAllOrders  END ********"+listOrders.size());


            }
            else{
                responseEntity.setStatusCode("500");
                responseEntity.setMessage("No Orders Found");
                responseEntity.setList(null);
                
            	logger.error("**********API getAllOrders END No Orders Found ********");

            }
        return  responseEntity;
    }
    
    @PostMapping("order/{customerId}/saveOrder/{productId}")
    public ResponseEntity saveOrder(@PathVariable(value = "customerId")int customerId,
    		@PathVariable(value = "productId")int productId,
    		@RequestBody OrderListDto orders){

    	logger.info("********** API  saveOrder ******** Start"+orders.getOrderDTOList().size());


        orderService.saveOrders(orders,customerId,productId);
        responseEntity.setStatusCode("200");
        responseEntity.setMessage("Success");
        
    	logger.info("********** API  saveOrder ******** END");

        
        return responseEntity;
    }
    
       
    @GetMapping("/getBill/{customerId}")
    public ResponseEntity getBill(@PathVariable(value = "customerId")int customerId) {
    	
    	logger.info("********** API  getBill ******** Start");

		List<OrderItemDTO>listResponse=orderService.getBill(customerId);
    	
		 if(listResponse.size()>0){
	          
	            responseEntity.setStatusCode("200");
	            responseEntity.setMessage("Success");
	            responseEntity.setList((ArrayList) listResponse);  

	            }
	            else{
	                responseEntity.setStatusCode("500");
	                responseEntity.setMessage("No Orders Bills Found");
	                responseEntity.setList(null);
	                System.out.println("********** API getBill Step 1 Else no orders found********");

	            }
	    	logger.info("********** API  getBill ******** End");

    	return responseEntity;
    }
    
       
}
