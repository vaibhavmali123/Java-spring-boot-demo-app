package com.demo.demo.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SubCategoryRequestDTO {

	@JsonProperty("categoryId")
		private int categoryId;

	@JsonProperty("isActive")
	private boolean isActive;
	
	@JsonProperty("sequence")
	private int sequence;
	
	@JsonProperty("subCategoryName")
	private String subCategoryName;

	public SubCategoryRequestDTO(int categoryId, boolean isActive, int sequence, String subCategoryName) {
		super();
		this.categoryId = categoryId;
		this.isActive = isActive;
		this.sequence = sequence;
		this.subCategoryName = subCategoryName;
	}

	public SubCategoryRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	

}
