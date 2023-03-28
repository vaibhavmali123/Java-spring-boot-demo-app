package com.demo.demo.dto;

import java.util.Date;

public class OrderItemDTO {

	
	private int quantity;
	
	private int price;
	
	private String  productName;
	
	private Date date;
	
	private String status;

	private int total;
	
	
	public OrderItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItemDTO(int quantity, String productName, Date date, String status,int price,int total) {
		super();
		this.quantity = quantity;
		this.productName = productName;
		this.date = date;
		this.status = status;
		this.price=price;
		this.total=total;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderItemDTO [quantity=" + quantity + ", price=" + price + ", productName=" + productName + ", date="
				+ date + ", status=" + status + ", total=" + total + "]";
	}
	
	
}
