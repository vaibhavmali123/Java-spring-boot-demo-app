package com.demo.demo.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class OrderDTO {

	
	   private int quantity;
	   
	   private int price;

	   private String date;

	   private String status;

	public OrderDTO(int quantity, int price, String date, String status) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.date = date;
		this.status = status;
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


	
}
