package com.demo.demo.dao;

import java.util.Date;
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
    
    
    @Query(value = "SELECT cat.category_id AS Id,cat.category_name AS itemName, sum(order_item.quantity)AS soldCount,order_item.quantity AS inStockCount FROM order_item  JOIN product ON order_item.product_id=product.product_id JOIN category cat ON product.category_id=cat.category_id JOIN ordertable o ON order_item.order_id=o.order_id WHERE o.date >= :startDate AND o.date <= :toDate GROUP BY cat.category_name",nativeQuery = true)
    List<ReportByCategoryCount>findReportsByCategoryAndDate(@Param("startDate")Date startDate,@Param("toDate")Date toDate);
    
    @Query(value = "SELECT cat.category_id AS Id,cat.category_name AS itemName, sum(order_item.quantity)AS soldCount,order_item.quantity AS inStockCount FROM order_item  JOIN product ON order_item.product_id=product.product_id JOIN category cat ON product.category_id=cat.category_id  GROUP BY cat.category_name",nativeQuery = true)
    List<ReportByCategoryCount>findReportsByCategory();
    
    @Query(value = "SELECT scat.sub_category_id AS Id,scat.sub_category_name AS itemName,sum(order_item.quantity)AS soldCount,product.quantity AS inStockCount FROM order_item JOIN product ON order_item.product_id=product.product_id JOIN sub_category scat ON product.sub_category_id=scat.sub_category_id JOIN ordertable o ON order_item.order_id=o.order_id  WHERE product.category_id= :categoryId and o.date >= :startDate AND o.date <= :toDate GROUP BY scat.sub_category_name",nativeQuery = true)
    List<ReportSubCategoryCount>findReportsBySubCategoryAndDate(@Param("categoryId")int categoryId,@Param("startDate")Date startDate,@Param("toDate")Date toDate);
    
    @Query(value = "SELECT cat.category_id AS Id,cat.category_name AS itemName, sum(order_item.quantity)AS soldCount,product.quantity AS inStockCount FROM order_item  JOIN product ON order_item.product_id=product.product_id JOIN category cat ON product.category_id=cat.category_id WHERE product.category_id=:categoryId GROUP BY cat.category_name",nativeQuery = true)
    List<ReportSubCategoryCount>findReportsBySubCategory(@Param("categoryId")int categoryId);

    
    
  
    // Queries for fetch sales report of product
    @Query(value = "SELECT pa.product_id AS productId,p.product_name AS productName,SUM(pa.sold_quantity) AS soldCount,pa.old_net_quantity AS netQuantity FROM productaudit pa JOIN product p ON pa.product_id=p.product_id JOIN category c ON pa.category_id=c.category_id WHERE pa.updated_date >= :startDate AND pa.updated_date < :toDate and c.category_id=:categoryId and sub_category.sub_category_id=:subCategoryId GROUP BY p.product_id",nativeQuery = true)
    List<ReportProductsCount>findReportsByProductAndDate(@Param("categoryId")int categoryId,@Param("subCategoryId")int subCategoryId,@Param("startDate")Date startDate,@Param("toDate")Date toDate);

    @Query(value = "SELECT pa.product_id AS productId,p.product_name AS productName,SUM(pa.sold_quantity) AS soldCount,pa.old_net_quantity AS netQuantity FROM productaudit pa JOIN product p ON pa.product_id=p.product_id JOIN category c ON pa.category_id=c.category_id WHERE c.category_id=:categoryId and pa.updated_date >= :startDate AND pa.updated_date < :toDate GROUP BY p.product_id",nativeQuery = true)
    List<ReportProductsCount>findReportsByProductAndDateExcludeSubCategory(@Param("categoryId")int categoryId,@Param("startDate")Date startDate,@Param("toDate")Date toDate);

   
    @Query(value = "SELECT pa.product_id AS productId,p.product_name AS productName,SUM(pa.sold_quantity) AS soldCount,pa.old_net_quantity AS netQuantity FROM productaudit pa JOIN product p ON pa.product_id=p.product_id JOIN category c ON pa.category_id=c.category_id WHERE c.category_id=:categoryId and sub_category_id=:subCategoryId GROUP BY p.product_id",nativeQuery = true)
    List<ReportProductsCount>findReportsByProduct(@Param("categoryId")int categoryId,@Param("subCategoryId")int subCategoryId);
    
    @Query(value = "SELECT pa.product_id AS productId,p.product_name AS productName,SUM(pa.sold_quantity) AS soldCount,pa.old_net_quantity AS netQuantity FROM productaudit pa JOIN product p ON pa.product_id=p.product_id JOIN category c ON pa.category_id=c.category_id WHERE c.category_id=:categoryId GROUP BY p.product_id",nativeQuery = true)
    List<ReportProductsCount>findReportsByProductExcludeSubCategoryId(@Param("categoryId")int categoryId);

}
