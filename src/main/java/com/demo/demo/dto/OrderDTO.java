package com.demo.demo.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.demo.demo.entities.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDTO implements Serializable{

	
	@JsonProperty("productId")
	   private int productId;

	
	@JsonProperty("customerId")
	   private int customerId;
	
	@JsonProperty("quantity")
	   private int quantity;
	   
	@JsonProperty("price")
	   private int price;

	@JsonProperty("date")
	   private String date;

	@JsonProperty("status")
	   private String status;

	   private String customerName;

	   private Customer customer;
	   
	

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public OrderDTO(int productId, int customerId, int quantity, int price, String date, String status,
			String customerName,Customer customer) {
		super();
		this.productId = productId;
		this.customerId = customerId;
		this.quantity = quantity;
		this.price = price;
		this.date = date;
		this.status = status;
		this.customerName = customerName;
		this.customer=customer;
	}

	public OrderDTO() {
		super();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "OrderDTO [productId=" + productId + ", customerId=" + customerId + ", quantity=" + quantity + ", price="
				+ price + ", date=" + date + ", status=" + status + ", customerName=" + customerName + ", customer="
				+ customer + "]";
	}


	
}
