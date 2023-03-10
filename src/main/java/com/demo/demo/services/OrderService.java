package com.demo.demo.services;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.demo.demo.entities.Category;
import com.demo.demo.entities.Customer;
import com.demo.demo.entities.OrderItem;
import com.demo.demo.entities.Orders;
import com.demo.demo.entities.Product;
import com.demo.demo.dao.OrderRepository;
import com.demo.demo.dao.ProductRepository;
import com.demo.demo.dto.OrderDTO;
import com.demo.demo.dto.OrderItemDTO;
import com.demo.demo.dto.OrderListDto;
import com.demo.demo.dto.OrderRequestDTO;
import com.demo.demo.dto.ProductRequestDTO;
import com.demo.demo.controllers.OrderController;
import com.demo.demo.dao.CategoryRepository;
import com.demo.demo.dao.CustomerRepository;
import com.demo.demo.dao.OrderItemRepository;

@Component
public class OrderService {
	private static final Logger logger = LogManager.getLogger(OrderService.class);

	
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
	CategoryRepository categoryRepository;

    public List<OrderDTO> getAllOrders(){
       
    	logger.info("********** Service  getAllOrders ******** Start");

    	OrderDTO orderDTO=new OrderDTO();
        List<OrderDTO> listOrdersDTO=new ArrayList();
    	
        List<Orders>listOrders=(List<Orders>) orderRepository.findAll();
        
        for(Orders ordersItem:listOrders) {
        	
        	orderDTO.setCustomerId(ordersItem.getCustomer().getId());
        	Customer customer=customerRepository.findById(ordersItem.getCustomer().getId());
        	
        	orderDTO.setDate(ordersItem.getDate());
        	orderDTO.setStatus(ordersItem.getStatus());
        	orderDTO.setCustomer(customer);

        	listOrdersDTO.add(orderDTO);
        }
    	logger.info("********** Service  getAllOrders ******** End"+listOrders.size());

            return listOrdersDTO;
    }

    public Orders saveOrders(OrderListDto orderListDto,int customerId){
                
    	logger.info("********** Service  saveOrders ******** Start");

         Customer customer=customerRepository.findById(customerId);
                  
         java.util.Date date=new java.util.Date();
         
         List<OrderRequestDTO>listOrderItems=orderListDto.getOrderDTOList();
         Orders orders=new Orders();
         orders.setCustomer(customer);
         orders.setDate(date.toString());
         orders.setStatus(listOrderItems.get(0).getStatus());
         Orders orderResponse=orderRepository.save(orders);
         
     	logger.info("********** Service saveOrders order saved ******** ");

         for(OrderRequestDTO item:listOrderItems) {
            
             OrderItem orderItem=new OrderItem();

        	 orderItem.setQuantity(item.getQuantity());
        	 
             Product productItem=productRepository.findById(item.getProductId());

        	 orderItem.setProduct(productItem);
             Orders ordersItem=orderRepository.findById(orderResponse.getOrderId());
             System.out.println("getProductId ID !orrrddeerr!!"+orderResponse.getOrderId());

             orderItem.setOrders(ordersItem);
        	 orderItemRepository.save(orderItem);
        	 
        	 productRepository.updateProductById(productItem.getProductId(),productItem.getQuantity()-item.getQuantity());
        	 
         	logger.info("********** Service saveOrders orderItem saved********"+item.getQuantity());

         }
     	logger.info("********** Service  saveOrders ******** End");

         return orders;
    }
    
    public Product saveProduct(ProductRequestDTO productRequestDTO){

    	logger.info("********** Service  saveProduct ******** Start");

    	Product product=new Product();
        Category category=categoryRepository.findById(productRequestDTO.getCategoryId());       
    	
    	product.setCategory(category);
    	product.setProductName(productRequestDTO.getProductName());
    	product.setUpdatedDate(productRequestDTO.getUpdatedDate());

    	product.setPrice(productRequestDTO.getPrice());
    	product.setCreatedDate(productRequestDTO.getCreatedDate());

    	product.setQuantity(productRequestDTO.getQuantity());
    	product.setComment(productRequestDTO.getComment());
    	Product productrs=productRepository.save(product);

    	logger.info("********** Service  saveProduct ******** End"+productRequestDTO.getQuantity());

         return productrs;
    }

	public List<OrderItemDTO> getBill(int customerId) {
		// TODO Auto-generated method stub
    	logger.info("********** Service getBill ******** Start");

		List<OrderItemDTO>listResponse=new ArrayList<OrderItemDTO>();
		
		List<Orders>listOrders=orderRepository.findByCustomerId(customerId);
		
    	logger.info("********** Service getBill listOrders********"+listOrders.size());
        
       
        for(Orders item:listOrders) {
        	
        OrderItem orderItem=orderItemRepository.findByOrderId(item.getOrderId());
       
    	logger.info("********** Service getBill getOrderId********"+item.getOrderId());

        if(orderItem!=null) {
         
            Product product=orderItem.getProduct();

           OrderItemDTO orderItemDTO=new OrderItemDTO();
           
           orderItemDTO.setProductName(product.getProductName());
           orderItemDTO.setDate(item.getDate());
           orderItemDTO.setQuantity(orderItem.getQuantity());
           orderItemDTO.setPrice(product.getPrice());
           orderItemDTO.setStatus(item.getStatus());
           //orderItemDTO.setTotal(product.getPrice()*item.getQuantity());
           listResponse.add(orderItemDTO);
        	
        }
        }
    	logger.info("********** Service getBill End ********");

		return listResponse;
	}
}