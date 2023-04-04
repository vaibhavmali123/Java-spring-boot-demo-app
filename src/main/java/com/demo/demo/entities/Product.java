package com.demo.demo.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "product")
public class Product implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;
	
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "quantity")
	private int quantity;
	
	
	@Column(name = "comment")
	private String comment;
	

	@Column(name = "productImage")
	private String productImage;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	@Column(name = "created_date")
	private Date createdDate;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	@Column(name = "updated_date")
	private Date updatedDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subCategoryId")
	private Subcategory subcategory;
	
	/*
	 * @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY,orphanRemoval
	 * = true) List<Orders>Orders;
	 */
	public Product(int productId,String productName, Date createdDate, Date updatedDate,
			int price,Category category,String comment,int quantity,Subcategory subcategory,String productImage) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		//Orders = orders;
		this.price=price;
		this.category=category;
		this.comment=comment;
		this.quantity=quantity;
		this.subcategory=subcategory;
		this.productImage=productImage;
	}
	
	

	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/*
	 * public List<Orders> getOrders() { return Orders; }
	 * 
	 * public void setOrders(List<Orders> orders) { Orders = orders; }
	 */



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}



	public Subcategory getSubcategory() {
		return subcategory;
	}



	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}



	public String getProductImage() {
		return productImage;
	}



	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}



	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", quantity="
				+ quantity + ", comment=" + comment + ", productImage=" + productImage + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", category=" + category + ", subcategory=" + subcategory + "]";
	}

	
}
