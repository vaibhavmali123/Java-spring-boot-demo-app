package com.demo.demo.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoryId")
	private int categoryId;

	@Column(name = "categoryName")
	private String categoryName;

	@Column(name = "createdDate")
	private String createdDate;

	/*
	 * @OneToMany(mappedBy = "category") private List<Product>listProducts;
	 */
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Category(int categoryId, String categoryName, String createdDate, List<Product> listProducts) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.createdDate = createdDate;
		//this.listProducts = listProducts;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}



	/*
	 * public List<Product> getListProducts() { return listProducts; }
	 * 
	 * 
	 * public void setListProducts(List<Product> listProducts) { this.listProducts =
	 * listProducts; }
	 */

	
}
