package com.demo.demo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class CategoryDTO {

	
	@JsonProperty("categoryName")
	private String categoryName;

	@JsonProperty("isActive")
	private boolean isActive;
	
	@JsonProperty("sequence")
	private int sequence;
	

	public CategoryDTO(String categoryName, boolean isActive, int sequence) {
		super();
		this.categoryName = categoryName;
		this.isActive = isActive;
		this.sequence = sequence;
	}

	
	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
	
	
	

}