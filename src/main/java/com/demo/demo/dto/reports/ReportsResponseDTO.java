package com.demo.demo.dto.reports;

public class ReportsResponseDTO {

	private int categoryId;
	
	private String categoryName;
	
	private int soldCount;
	
	private int inStockCount;

	public ReportsResponseDTO(int categoryId, String categoryName, int soldCount, int inStockCount) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.soldCount = soldCount;
		this.inStockCount = inStockCount;
	}

	public ReportsResponseDTO() {
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

	public int getSoldCount() {
		return soldCount;
	}

	public void setSoldCount(int soldCount) {
		this.soldCount = soldCount;
	}

	public int getInStockCount() {
		return inStockCount;
	}

	public void setInStockCount(int inStockCount) {
		this.inStockCount = inStockCount;
	}

	@Override
	public String toString() {
		return "ReportsResponseDTO [categoryId=" + categoryId + ", categoryName=" + categoryName + ", soldCount="
				+ soldCount + ", inStockCount=" + inStockCount + "]";
	}
	
	
}
