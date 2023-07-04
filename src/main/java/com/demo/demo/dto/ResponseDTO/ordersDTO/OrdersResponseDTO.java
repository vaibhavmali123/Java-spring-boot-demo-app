package com.demo.demo.dto.ResponseDTO.ordersDTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.demo.demo.dto.ResponseDTO.ProductsResponseDTO;
import com.demo.demo.entities.Customer;
import com.demo.demo.entities.OrderItem;
import com.fasterxml.jackson.annotation.JsonFormat;

import net.bytebuddy.asm.Advice.This;

public class OrdersResponseDTO implements Serializable{
	
   private int orderId;

   private Date date;

   private String status;
   
    private Customer customer;
    private ProductsResponseDTO productsResponseDTO;
	public OrdersResponseDTO(int orderId, Date date, String status, Customer customer, List<OrderItem> listItem,ProductsResponseDTO productsResponseDTO) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.status = status;
		this.customer = customer;
		this.productsResponseDTO=productsResponseDTO;
	}
	
	
	public OrdersResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	public ProductsResponseDTO getProductsResponseDTO() {
		return productsResponseDTO;
	}
	public void setProductsResponseDTO(ProductsResponseDTO productsResponseDTO) {
		this.productsResponseDTO = productsResponseDTO;
	}
	@Override
	public String toString() {
		return "OrdersResponseDTO [orderId=" + orderId + ", date=" + date + ", status=" + status + ", customer="
				+ customer + ", productsResponseDTO=" + productsResponseDTO + "]";
	}

    

}
