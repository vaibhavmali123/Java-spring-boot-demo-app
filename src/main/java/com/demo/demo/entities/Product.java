package com.demo.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private int productId;
	
	
	@Column(name = "product_name")
	private String productName;
	

	@Column(name = "created_date")
	private String createdDate;
	
	@Column(name = "updated_date")
	private String updatedDate;

	@OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY,orphanRemoval = true)
	List<Orders>Orders;

	public Product(int productId,String productName, String createdDate, String updatedDate,
			List<com.demo.demo.entities.Orders> orders) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		Orders = orders;
	}
	
	

	public Product() {
		super();
	}



	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<Orders> getOrders() {
		return Orders;
	}

	public void setOrders(List<Orders> orders) {
		Orders = orders;
	}

	
}
