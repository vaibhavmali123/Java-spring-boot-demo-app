package com.demo.demo.dto.ResponseDTO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.demo.demo.entities.Category;
import com.fasterxml.jackson.annotation.JsonFormat;

public class SubCategoryResponseDTO {
	
	
	private int subCategoryId;

	private String subCategoryName;

	private boolean isActive;
	
	private int sequence;
	
	private int categoryId;

	public SubCategoryResponseDTO(int subCategoryId, String subCategoryName, boolean isActive, int sequence,
			int categoryId) {
		super();
		this.subCategoryId = subCategoryId;
		this.subCategoryName = subCategoryName;
		this.isActive = isActive;
		this.sequence = sequence;
		this.categoryId = categoryId;
	}

	public SubCategoryResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	

}
