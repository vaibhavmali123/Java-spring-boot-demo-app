package com.demo.demo.dto;

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

public ProductRequestDTO() {
	super();
	// TODO Auto-generated constructor stub
}

public ProductRequestDTO(String productName, int price, String updatedDate, String createdDate, int quantity,
		String comment,int categoryId,int subCategoryId,String productImage) {
	super();
	this.productName = productName;
	this.price = price;
	this.updatedDate = updatedDate;
	this.createdDate = createdDate;
	this.quantity = quantity;
	this.comment = comment;
	this.categoryId=categoryId;
	this.subCategoryId=subCategoryId;
	this.productImage=productImage;
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

@Override
public String toString() {
	return "ProductRequestDTO [categoryId=" + categoryId + ", subCategoryId=" + subCategoryId + ", productName="
			+ productName + ", price=" + price + ", updatedDate=" + updatedDate + ", createdDate=" + createdDate
			+ ", quantity=" + quantity + ", comment=" + comment + ", productImage=" + productImage + "]";
}



}
