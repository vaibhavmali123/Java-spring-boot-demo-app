package com.demo.demo.dto.reports;

import java.util.Date;

public class ReportsRequestDTO {

	
	   private Date fromDate;
	   
	   private Date toDate;
	   
		private int categoryId;

		private int subCategoryId;

		private int productId;

		public ReportsRequestDTO(Date fromDate, Date toDate, int categoryId, int subCategoryId, int productId) {
			super();
			this.fromDate = fromDate;
			this.toDate = toDate;
			this.categoryId = categoryId;
			this.subCategoryId = subCategoryId;
			this.productId = productId;
		}

		public ReportsRequestDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Date getFromDate() {
			return fromDate;
		}

		public void setFromDate(Date fromDate) {
			this.fromDate = fromDate;
		}

		public Date getToDate() {
			return toDate;
		}

		public void setToDate(Date toDate) {
			this.toDate = toDate;
		}

		public int getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}

		public int getSubCategoryId() {
			return subCategoryId;
		}

		public void setSubCategoryId(int subCategoryId) {
			this.subCategoryId = subCategoryId;
		}

		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}

		@Override
		public String toString() {
			return "ReportsRequestDTO [fromDate=" + fromDate + ", toDate=" + toDate + ", categoryId=" + categoryId
					+ ", subCategoryId=" + subCategoryId + ", productId=" + productId + "]";
		}

		

}
