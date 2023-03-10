package com.demo.demo.services;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.demo.demo.entities.Customer;
import com.demo.demo.entities.OrderItem;
import com.demo.demo.entities.Orders;
import com.demo.demo.entities.Product;
import com.demo.demo.dao.OrderRepository;
import com.demo.demo.dao.ProductRepository;
import com.demo.demo.dto.OrderDTO;
import com.demo.demo.dao.CustomerRepository;
import com.demo.demo.dao.OrderItemRepository;

@Component
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    
    public List<Orders> getAllOrders(){
       
        List<Orders>listOrders=(List<Orders>) orderRepository.findAll();

            return listOrders;
    }

    public Orders saveOrders(Orders orders,int customerId,int productId){
                
          System.out.println("********** saveOrders ******** Start"+customerId);

         Customer customer=customerRepository.findById(customerId);
         Product product=productRepository.findById(productId);
         OrderItem orderItem=new OrderItem();
         
         
         orders.setCustomer(customer);
         orders.setProduct(product);
         

         
         List<OrderItem>listOrderItems=orders.getOrderItems();

         for(OrderItem item:listOrderItems) {
             System.out.println("********** saveOrders ******** Ieration"+customerId);
             System.out.println("getProductId ID !!!"+listOrderItems.get(0).getQuantity());

        	 orderItem.setQuantity(item.getQuantity());
        	 
             Product productItem=productRepository.findById(listOrderItems.get(0).getQuantity());

        	 orderItem.setProduct(productItem);
        	 orderItemRepository.save(orderItem);
         }
         System.out.println("PRD ID !!!"+listOrderItems.get(0).getQuantity());

         orders=orderRepository.save(orders);
    
         
         
         return orders;
    }
    
    public Product saveProduct(Product product){

    	Product products=new Product();
               
    	products=productRepository.save(product);

         return products;
    }
}