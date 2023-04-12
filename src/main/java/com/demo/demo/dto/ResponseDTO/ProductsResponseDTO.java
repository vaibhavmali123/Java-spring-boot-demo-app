package com.demo.demo.dto.ResponseDTO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.demo.demo.entities.Category;
import com.demo.demo.entities.Subcategory;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ProductsResponseDTO {

	private int productId;
	
	
	private String productName;
	
	@Column(name = "price")
	private int price;
	
	private int quantity;
	
	private String comment;
	
	private String productImage;
	
	private Date createdDate;
	
	private Date updatedDate;

	private int categoryId;
	
	private int subCategoryId;

	public ProductsResponseDTO(int productId, String productName, int price, int quantity, String comment,
			String productImage, Date createdDate, Date updatedDate, int categoryId, int subCategoryId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.comment = comment;
		this.productImage = productImage;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.categoryId = categoryId;
		this.subCategoryId = subCategoryId;
	}

	public ProductsResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	@Override
	public String toString() {
		return "ProductsResponseDTO [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", quantity=" + quantity + ", comment=" + comment + ", productImage=" + productImage
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", categoryId=" + categoryId
				+ ", subCategoryId=" + subCategoryId + "]";
	}

	
	
}
