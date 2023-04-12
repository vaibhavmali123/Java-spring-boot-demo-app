package com.demo.demo.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

@Entity
@Table(name = "subCategory")
public class Subcategory {

	public int getSubCategoryId() {
		return subCategoryId;
	}


	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subCategoryId")
	private int subCategoryId;

	@Column(name = "subCategoryName")
	private String subCategoryName;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	@Column(name = "createdDate")
	private Date createdDate;

	@Column(name = "isActive")
	private boolean isActive;
	
	@Column(name = "sequence")
	private int sequence;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "categoryId",referencedColumnName = "categoryId",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Category category;
	

	public Subcategory(int subCategoryId, String subCategoryName, Date createdDate, boolean isActive, int sequence,Category category) {
		super();
		this.subCategoryId = subCategoryId;
		this.subCategoryName = subCategoryName;
		this.createdDate = createdDate;
		this.isActive = isActive;
		this.sequence = sequence;
		this.category=category;
	}

	
	public Subcategory() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getCategoryId() {
		return subCategoryId;
	}

	public void setCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
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


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Subcategory [subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName + ", createdDate="
				+ createdDate + ", isActive=" + isActive + ", sequence=" + sequence + "]";
	}

	
}
