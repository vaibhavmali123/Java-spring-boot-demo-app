package com.demo.demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.dto.ProductRequestDTO;
import com.demo.demo.entities.ResponseEntity;

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
import com.demo.demo.dto.ResponseDTO.ProductsResponseDTO;
import com.demo.demo.entities.Orders;
import com.demo.demo.entities.Product;
import com.demo.demo.entities.ResponseEntity;
import com.demo.demo.entities.Subcategory;
import com.demo.demo.services.OrderService;
import com.demo.demo.services.ProductService;
import com.demo.demo.services.SubCategoryService;

@RestController
public class ProductController {
	private static final Logger logger = LogManager.getLogger(ProductController.class);

    @Autowired
    SubCategoryService subCategoryService;
    ResponseEntity responseEntity=new ResponseEntity();


    @Autowired
    ProductService productService;
    
	 @PostMapping("/saveProduct")
	    public ResponseEntity saveProduct(@RequestBody ProductRequestDTO productRequestDTO){

		    ResponseEntity responseEntity=new ResponseEntity();

	    	logger.info("********** API  saveProduct ******** Start");

	        productService.saveProduct(productRequestDTO);
	        responseEntity.setStatusCode("200");
	        responseEntity.setMessage("Success");
	  
	    	logger.info("********** API  saveProduct ******** End"+productRequestDTO.getProductName());

	        return responseEntity;
	    }
	 
	 @GetMapping("getProductsById")
		public ResponseEntity getProductsById(
				@RequestParam(value = "categoryId")int categoryId,@RequestParam(value = "subCategoryId")int subCategoryId)
		{
	    	logger.info("********** API  getProductsById ******** Start");
	    	try {

		    	List<ProductsResponseDTO>productList=new ArrayList<ProductsResponseDTO>();
		    	
		    	if (subCategoryId!=0) {
		    		productList.clear();
		    		productList= productService.getProductsById(categoryId,subCategoryId);
				}
		    	else {
		    		productList.clear();
		    		productList= productService.getProductsByCategoryId(categoryId);

		    	}
						if(!productList.isEmpty()) {
							
					    	logger.info("********** API  getProductsById ******** End"+"CatId:"+categoryId+" SubCatId"+subCategoryId);
							responseEntity.setStatusCode("200");
							responseEntity.setMessage("Success");
							responseEntity.setList((ArrayList)productList);
						}
						else {
							productList.clear();
					    	logger.info("********** API  getProductsById from else ******** End"+"CatId:"+categoryId+" SubCatId"+subCategoryId);
							responseEntity.setStatusCode("500");
							responseEntity.setMessage("Failed to fetch products");
							responseEntity.setList((ArrayList)productList);
						}
			} catch (Exception e) {
				// TODO: handle exception
			}			
			return responseEntity;
		}
	 @PostMapping("updateProduct")
	 public ResponseEntity updateProduct(@RequestBody ProductRequestDTO productRequestDTO,@RequestParam(value = "productId")int productId) {
	    	logger.info("********** API  updateProduct ******** START");

		 try {
			 
			 int result=productService.updateProduct(productRequestDTO,productId);
			 if(result>0) {
					responseEntity.setStatusCode("200");
					responseEntity.setMessage("Success");
				}
				else {
					responseEntity.setStatusCode("500");
					responseEntity.setMessage("Failed to fetch categories");
				}
			
		} catch (Exception e) {
	    	logger.info("********** API  updateProduct ******** END"+e.getMessage());
		}
	    	logger.info("********** API  updateProduct ******** END");
		return responseEntity;
	 }
	 @PostMapping("deleteProduct")
		public ResponseEntity deleteCategory(@RequestParam(value = "productId")int productId) {
		    	logger.info("********** API deleteCategory ******** START");
				try {
						productService.deleteProductById(productId);
						responseEntity.setStatusCode("200");
						responseEntity.setMessage("Success");	
				}
				catch (Exception e) {
			    	logger.info("********** API deleteCategory ******** END");
			    	responseEntity.setStatusCode("500");
					responseEntity.setMessage("Please delete first corresponding items");
			
				}
		    	logger.info("********** API deleteCategory ******** END");
				return responseEntity;
			}


}
