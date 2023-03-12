package com.demo.demo.dto;

public class ProductRequestDTO {

	
private int categoryId;	
private String productName;

private int price;

private String updatedDate;

private String createdDate;

private int quantity;

private String comment;

public ProductRequestDTO() {
	super();
	// TODO Auto-generated constructor stub
}

public ProductRequestDTO(String productName, int price, String updatedDate, String createdDate, int quantity,
		String comment,int categoryId) {
	super();
	this.productName = productName;
	this.price = price;
	this.updatedDate = updatedDate;
	this.createdDate = createdDate;
	this.quantity = quantity;
	this.comment = comment;
	this.categoryId=categoryId;
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



}
