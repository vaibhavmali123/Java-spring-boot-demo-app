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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "productaudit")
public class ProductAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "audit_id")
	private int auditId;
	
	@ManyToOne
	@JoinColumn(name = "product_id",nullable = false)
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subCategoryId")
	private Subcategory subcategory;
	
	@Column(name = "price")
	private int price;
	
	
	@Column(name = "netQuantity")
	private int netQuantity;

	@Column(name = "oldNetQuantity")
	private int oldNetQuantity;

	
	@Column(name = "soldQuantity")
	private int soldQuantity;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	@Column(name = "updated_date")
	private Date updatedDate;
	
	@Column(name = "updatedBy")
	private int updatedBy;
	
	@Column(name = "activity")
	private String activity;


	
	public ProductAudit(int auditId, Product product, Category category, Subcategory subcategory, int price,int oldNetQuantity,
			int netQuantity, int soldQuantity, Date updatedDate, int updatedBy, String activity) {
		super();
		this.auditId = auditId;
		this.product = product;
		this.category = category;
		this.subcategory = subcategory;
		this.price = price;
		this.netQuantity = netQuantity;
		this.soldQuantity = soldQuantity;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.activity = activity;
		this.oldNetQuantity=oldNetQuantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public ProductAudit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAuditId() {
		return auditId;
	}

	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNetQuantity() {
		return netQuantity;
	}

	public void setNetQuantity(int netQuantity) {
		this.netQuantity = netQuantity;
	}

	public int getSoldQuantity() {
		return soldQuantity;
	}

	public void setSoldQuantity(int soldQuantity) {
		this.soldQuantity = soldQuantity;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public int getOldNetQuantity() {
		return oldNetQuantity;
	}

	public void setOldNetQuantity(int oldNetQuantity) {
		this.oldNetQuantity = oldNetQuantity;
	}
		
	
}
