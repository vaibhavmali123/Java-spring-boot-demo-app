package com.demo.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderRequestDTO {

	
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

	
	
	
	
	public OrderRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderRequestDTO(int productId, int customerId, int quantity, int price, String date, String status) {
		super();
		this.productId = productId;
		this.customerId = customerId;
		this.quantity = quantity;
		this.price = price;
		this.date = date;
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

	
	
	
	
}
