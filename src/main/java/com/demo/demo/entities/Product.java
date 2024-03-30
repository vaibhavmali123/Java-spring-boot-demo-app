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

	@Column(name = "availableQuantity")
	private int availableQuantity;

	
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
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "purchasePrice")
	private String purchasePrice;
	
	@Column(name = "tax")
	private String tax;
	
	@Column(name = "lowStock")
	private String lowStock;
	
	@Column(name = "itemType")
	private String itemType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryId")
	private Category category;
	
	public Product(int productId, String productName, int price, int quantity, String comment, String productImage,
			Date createdDate, Date updatedDate, String unit, String purchasePrice, String tax, String lowStock,
			String itemType, Category category, Subcategory subcategory,int availableQuantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.comment = comment;
		this.productImage = productImage;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.unit = unit;
		this.purchasePrice = purchasePrice;
		this.tax = tax;
		this.lowStock = lowStock;
		this.itemType = itemType;
		this.category = category;
		this.subcategory = subcategory;
		this.availableQuantity=availableQuantity;
	}



	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subCategoryId")
	private Subcategory subcategory;
	
	/*
	 * @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY,orphanRemoval
	 * = true) List<Orders>Orders;
	 */
	public Product(int productId,String productName, Date createdDate, Date updatedDate,
			int price,Category category,String comment,int quantity,Subcategory subcategory,String productImage,int availableQuantity) {
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
		this.availableQuantity=availableQuantity;
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
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", quantity="
				+ quantity + ", availableQuantity=" + availableQuantity + ", comment=" + comment + ", productImage="
				+ productImage + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", unit=" + unit
				+ ", purchasePrice=" + purchasePrice + ", tax=" + tax + ", lowStock=" + lowStock + ", itemType="
				+ itemType + ", category=" + category + ", subcategory=" + subcategory + "]";
	}

	
}
