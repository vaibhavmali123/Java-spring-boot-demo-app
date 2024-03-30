package com.demo.demo.dto;

import javax.persistence.Column;

public class ProductRequestDTO {

	
private int categoryId;	

private int subCategoryId;	

private String productName;

private int price;

private String updatedDate;

private String createdDate;

private int quantity;

private String comment;

private String productImage;

private String unit;

private String purchasePrice;

private String tax;

private String lowStock;

private String itemType;


public ProductRequestDTO(int categoryId, int subCategoryId, String productName, int price, String updatedDate,
		String createdDate, int quantity, String comment, String productImage, String unit, String purchasePrice,
		String tax, String lowStock, String itemType) {
	super();
	this.categoryId = categoryId;
	this.subCategoryId = subCategoryId;
	this.productName = productName;
	this.price = price;
	this.updatedDate = updatedDate;
	this.createdDate = createdDate;
	this.quantity = quantity;
	this.comment = comment;
	this.productImage = productImage;
	this.unit = unit;
	this.purchasePrice = purchasePrice;
	this.tax = tax;
	this.lowStock = lowStock;
	this.itemType = itemType;
}

public ProductRequestDTO() {
	super();
	// TODO Auto-generated constructor stub
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

public String getUpdatedDate() {
	return updatedDate;
}

public void setUpdatedDate(String updatedDate) {
	this.updatedDate = updatedDate;
}

public String getCreatedDate() {
	return createdDate;
}

public void setCreatedDate(String createdDate) {
	this.createdDate = createdDate;
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


public String getProductImage() {
	return productImage;
}

public void setProductImage(String productImage) {
	this.productImage = productImage;
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
	return "ProductRequestDTO [categoryId=" + categoryId + ", subCategoryId=" + subCategoryId + ", productName="
			+ productName + ", price=" + price + ", updatedDate=" + updatedDate + ", createdDate=" + createdDate
			+ ", quantity=" + quantity + ", comment=" + comment + ", productImage=" + productImage + ", unit=" + unit
			+ ", purchasePrice=" + purchasePrice + ", tax=" + tax + ", lowStock=" + lowStock + ", itemType=" + itemType
			+ "]";
}



}
