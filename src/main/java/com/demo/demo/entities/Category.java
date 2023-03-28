package com.demo.demo.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoryId")
	private int categoryId;

	@Column(name = "categoryName")
	private String categoryName;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	@Column(name = "createdDate")
	private Date createdDate;

	@Column(name = "isActive")
	private boolean isActive;
	
	@Column(name = "sequence")
	private int sequence;
	
	/*
	 * @OneToMany(mappedBy = "category") private List<Product>listProducts;
	 */
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Category(int categoryId, String categoryName, Date createdDate, List<Product> listProducts) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.createdDate = createdDate;
		this.isActive=isActive;
		this.sequence=sequence;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public int getSequence() {
		return sequence;
	}


	public void setSequence(int sequence) {
		this.sequence = sequence;
	}



	/*
	 * public List<Product> getListProducts() { return listProducts; }
	 * 
	 * 
	 * public void setListProducts(List<Product> listProducts) { this.listProducts =
	 * listProducts; }
	 */

	
}
