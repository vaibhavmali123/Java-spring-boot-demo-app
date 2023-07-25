package com.demo.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.demo.dto.reports.ReportsResponseDTO;
import com.demo.demo.entities.Customer;
import com.demo.demo.entities.OrderItem;
import com.demo.demo.entities.Orders;

public interface OrderItemRepository extends CrudRepository<OrderItem,Integer>{

    public OrderItem findById(int id);

    @Query(value = "SELECT * FROM order_item WHERE order_id=:order_id",nativeQuery = true)
    OrderItem findByOrderId(@Param("order_id") int order_id);
    
    
    @Query(value = "SELECT cat.category_id AS categoryId,cat.category_name AS categoryName, sum(order_item.quantity)AS soldCount,order_item.quantity AS inStockCount FROM order_item  JOIN product ON order_item.product_id=product.product_id JOIN category cat ON product.category_id=cat.category_id GROUP BY cat.category_name",nativeQuery = true)
    List<ReportByCategoryCount>findReportsByCategory();
    
    @Query(value = "SELECT cat.category_id AS subCategoryId,cat.category_name AS SubCategoryName, sum(order_item.quantity)AS soldCount,product.quantity AS inStockCount FROM order_item  JOIN product ON order_item.product_id=product.product_id JOIN category cat ON product.category_id=cat.category_id WHERE product.category_id=:categoryId GROUP BY cat.category_name",nativeQuery = true)
    List<ReportSubCategoryCount>findReportsBySubCategory(@Param("categoryId")int categoryId);

    @Query(value = "SELECT cat.category_id AS productId,cat.category_name AS productName, sum(order_item.quantity)AS soldCount,product.quantity AS inStockCount FROM order_item  JOIN product ON order_item.product_id=product.product_id JOIN category cat ON product.category_id=cat.category_id WHERE product.category_id=:categoryId and sub_category_id=:subCategoryId GROUP BY cat.category_name",nativeQuery = true)
    List<ReportProductsCount>findReportsByProduct(@Param("categoryId")int categoryId,@Param("subCategoryId")int subCategoryId);

}
