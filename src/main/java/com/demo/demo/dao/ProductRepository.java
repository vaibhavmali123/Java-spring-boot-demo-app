package com.demo.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.demo.demo.dto.reports.ReportsResponseDTO;
import com.demo.demo.entities.Customer;
import com.demo.demo.entities.OrderItem;
import com.demo.demo.entities.Product;
import com.demo.demo.entities.Subcategory;

@EnableTransactionManagement
public interface ProductRepository extends CrudRepository<Product,Integer>{

	
    public Product findById(int id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value =  "UPDATE product p SET p.quantity=:quantity WHERE p.product_id=:product_id",nativeQuery = true)
    int updateProductQuantityById(@Param("product_id") int product_id,@Param("quantity") int quantity);

    @Query(value = "SELECT * FROM product WHERE category_id=:categoryId and sub_category_id=:subCategoryId",nativeQuery = true)
	List<Product>findAllById(@Param("categoryId") int categoryId,@Param("subCategoryId") int subCategoryId);

    @Query(value = "SELECT * FROM product WHERE category_id=:categoryId",nativeQuery = true)
   	List<Product>findAllBycategoryId(@Param("categoryId") int categoryId);

    @Query(value = "SELECT * FROM product WHERE product_id=:product_id",nativeQuery = true)
   	List<Product>findProductByProductID(@Param("product_id") int product_id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value =  "UPDATE product p SET p.quantity=:quantity,p.product_name=:productName,p.price=:price,p.quantity=:quantity,p.comment=:comment WHERE p.product_id=:product_id",nativeQuery = true)
	public int updateProductById(int product_id, String productName, int price, int quantity, String comment);
    

}
