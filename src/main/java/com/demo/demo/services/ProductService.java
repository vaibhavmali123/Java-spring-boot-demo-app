package com.demo.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.demo.dao.CategoryRepository;
import com.demo.demo.dao.ProductRepository;
import com.demo.demo.dao.SubCategoryRepository;
import com.demo.demo.dto.ProductRequestDTO;
import com.demo.demo.dto.ResponseDTO.ProductsResponseDTO;
import com.demo.demo.entities.Category;
import com.demo.demo.entities.Product;
import com.demo.demo.entities.Subcategory;

@Component
public class ProductService {
    
	private static final Logger logger = LogManager.getLogger(ProductService.class);


    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
	CategoryRepository categoryRepository;
    
    @Autowired
    SubCategoryRepository subCategoryRepository;


    public Product saveProduct(ProductRequestDTO productRequestDTO){

    	logger.info("********** Service  saveProduct ******** Start");

    	Product product=new Product();
        Category category=categoryRepository.findById(productRequestDTO.getCategoryId());       
    	Subcategory subcategory=subCategoryRepository.findById(productRequestDTO.getSubCategoryId());
        
    	product.setCategory(category);
    	product.setProductName(productRequestDTO.getProductName());
    	product.setUpdatedDate(new Date());

    	product.setPrice(productRequestDTO.getPrice());
    	product.setCreatedDate(new Date());

    	product.setSubcategory(subcategory);
    	product.setQuantity(productRequestDTO.getQuantity());
    	product.setComment(productRequestDTO.getComment());
    	Product productrs=productRepository.save(product);

    	logger.info("********** Service  saveProduct ******** End"+productRequestDTO.getQuantity());

         return productrs;
    }

    public List<ProductsResponseDTO> getProductsById(int categoryId,int subCategoryId) {
    	
    List<ProductsResponseDTO>productsListResponse =  new ArrayList<ProductsResponseDTO>();
    
    	List<Product>productsList=productRepository.findAllById(categoryId,subCategoryId);
    	
    	
    	for(Product product:productsList) {
    		
    		ProductsResponseDTO productsResponseDTO=new ProductsResponseDTO();
    		
    		productsResponseDTO.setCategoryId(product.getCategory().getCategoryId());
    		productsResponseDTO.setSubCategoryId(product.getSubcategory().getCategoryId());
    		
    		productsResponseDTO.setProductName(product.getProductName());
    		productsResponseDTO.setProductImage(product.getProductImage());
    		productsResponseDTO.setProductId(product.getProductId());
    		productsResponseDTO.setPrice(product.getPrice());
    		productsResponseDTO.setQuantity(product.getQuantity());
    		productsResponseDTO.setComment(product.getComment());
    		
    		productsListResponse.add(productsResponseDTO);
    	}
    	return productsListResponse;
    }

    public List<ProductsResponseDTO> getProductsByCategoryId(int categoryId) {
    	
    List<ProductsResponseDTO>productsListResponse =  new ArrayList<ProductsResponseDTO>();
    
    	List<Product>productsList=productRepository.findAllBycategoryId(categoryId);
    	
    	
    	for(Product product:productsList) {
    		
    		ProductsResponseDTO productsResponseDTO=new ProductsResponseDTO();
    		
    		productsResponseDTO.setCategoryId(product.getCategory().getCategoryId());
    		productsResponseDTO.setSubCategoryId(product.getSubcategory().getCategoryId());
    		
    		productsResponseDTO.setProductName(product.getProductName());
    		productsResponseDTO.setProductImage(product.getProductImage());
    		productsResponseDTO.setProductId(product.getProductId());
    		productsResponseDTO.setPrice(product.getPrice());
    		productsResponseDTO.setQuantity(product.getQuantity());
    		productsResponseDTO.setComment(product.getComment());
    		
    		productsListResponse.add(productsResponseDTO);
    	}
    	return productsListResponse;
    }

}
