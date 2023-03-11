package com.demo.demo.services;
import java.util.ArrayList;
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
import com.demo.demo.dto.OrderListDto;
import com.demo.demo.dto.OrderRequestDTO;
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

    
    public List<OrderDTO> getAllOrders(){
       
    	OrderDTO orderDTO=new OrderDTO();
        List<OrderDTO> listOrdersDTO=new ArrayList();
    	
        List<Orders>listOrders=(List<Orders>) orderRepository.findAll();
        
        for(Orders ordersItem:listOrders) {
        	
        	orderDTO.setCustomerId(ordersItem.getCustomer().getId());
        	Customer customer=customerRepository.findById(ordersItem.getCustomer().getId());
        	
        	orderDTO.setDate(ordersItem.getDate());
        	orderDTO.setPrice(ordersItem.getPrice());
        	orderDTO.setQuantity(ordersItem.getQuantity());
        	orderDTO.setStatus(ordersItem.getStatus());
        	orderDTO.setCustomer(customer);

        	listOrdersDTO.add(orderDTO);
        }
        
            return listOrdersDTO;
    }

    public Orders saveOrders(OrderListDto orderListDto,int customerId){
                
          System.out.println("********** saveOrders Service ******** Start"+customerId);

         Customer customer=customerRepository.findById(customerId);
         //Product product=productRepository.findById(productId);
         OrderItem orderItem=new OrderItem();
         
         
    //     orders.setCustomer(customer);
//         orders.setProduct(product);
         

         
         List<OrderRequestDTO>listOrderItems=orderListDto.getOrderDTOList();
         Orders orders=new Orders();
         orders.setCustomer(customer);
         orders.setDate(listOrderItems.get(0).getDate());
         orders.setPrice(listOrderItems.get(0).getPrice());
         orders.setQuantity(listOrderItems.get(0).getQuantity());
         orders.setStatus(listOrderItems.get(0).getStatus());
         
         
         Orders orderResponse=orderRepository.save(orders);
         System.out.println("********** Order Saved ******** ");

         for(OrderRequestDTO item:listOrderItems) {
             System.out.println("********** saveOrders ******** Ieration"+customerId);
             System.out.println("getProductId ID !!!"+listOrderItems.get(0).getQuantity());
             System.out.println("getProductId ID !ggg!!"+item.getProductId());


        	 orderItem.setQuantity(item.getQuantity());
        	 
        	 
             Product productItem=productRepository.findById(item.getProductId());

        	 orderItem.setProduct(productItem);
             Orders ordersItem=orderRepository.findById(orderResponse.getOrderId());
             System.out.println("getProductId ID !orrrddeerr!!"+orderResponse.getOrderId());

             orderItem.setOrders(ordersItem);
        	 orderItemRepository.save(orderItem);
         }
         System.out.println("PRD ID !!!"+listOrderItems.get(0).getQuantity());

    
         
         
         return orders;
    }
    
    public Product saveProduct(Product product){

    	Product products=new Product();
               
    	products=productRepository.save(product);

         return products;
    }
}