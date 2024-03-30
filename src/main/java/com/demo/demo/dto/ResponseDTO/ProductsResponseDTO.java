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
	
	private int price;
	
	private int quantity;
	
	private int availableQuantity;

	private String comment;
	
	private String productImage;
	
	private Date createdDate;
	
	private Date updatedDate;

	private int categoryId;
	
	private int subCategoryId;
	
	private String unit;

	private String purchasePrice;

	private String tax;

	private String lowStock;

	private String itemType;


	public ProductsResponseDTO(int productId, String productName, int price, int quantity, String comment,
			String productImage, Date createdDate, Date updatedDate, int categoryId, int subCategoryId, String unit,
			String purchasePrice, String tax, String lowStock, String itemType,int availableQuantity) {
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
		this.unit = unit;
		this.purchasePrice = purchasePrice;
		this.tax = tax;
		this.lowStock = lowStock;
		this.itemType = itemType;
		this.availableQuantity=availableQuantity;
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

	
	
	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
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

	
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getLowStock() {
		return lowStock;
	}

	public void setLowStock(String lowStock) {
		this.lowStock = lowStock;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	@Override
	public String toString() {
		return "ProductsResponseDTO [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", quantity=" + quantity + ", availableQuantity=" + availableQuantity + ", comment=" + comment
				+ ", productImage=" + productImage + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", categoryId=" + categoryId + ", subCategoryId=" + subCategoryId + ", unit=" + unit
				+ ", purchasePrice=" + purchasePrice + ", tax=" + tax + ", lowStock=" + lowStock + ", itemType="
				+ itemType + "]";
	}

	
	
}
