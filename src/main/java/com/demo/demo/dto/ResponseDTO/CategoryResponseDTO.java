package com.demo.demo.dto.ResponseDTO;

import java.util.Date;


public class CategoryResponseDTO {

	
	private int categoryId;

	private String categoryName;

	private Date createdDate;

	private boolean isActive;
	
	private int sequence;

	public CategoryResponseDTO(int categoryId, String categoryName, Date createdDate, boolean isActive, int sequence) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.createdDate = createdDate;
		this.isActive = isActive;
		this.sequence = sequence;
	}

	public CategoryResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "CategoryResponseDTO [categoryId=" + categoryId + ", categoryName=" + categoryName + ", createdDate="
				+ createdDate + ", isActive=" + isActive + ", sequence=" + sequence + "]";
	}

	
}
