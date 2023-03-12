package com.demo.demo.entities;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ordertable")
public class Orders implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderId")   
   private int orderId;

   @Column(name="quantity")   
   private int quantity;
   
   @Column(name="price")   
   private int price;

   @Column(name="date")   
   private String date;

   @Column(name="status")   
   private String status;


   @ManyToOne(fetch = FetchType.LAZY,optional = false)
   @JoinColumn(name = "customer_id",referencedColumnName = "customer_id",nullable = false)
   @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;

	/*
	 * @Transient
	 * 
	 * @ManyToOne(fetch = FetchType.LAZY,optional = false)
	 * 
	 * @JoinColumn(name = "product_id",referencedColumnName = "product_id",nullable
	 * = false) private Product product;
	 */

	@OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)
	private List<OrderItem>orderItems;
	
	public Orders(int orderId, int quantity, int price, String date, String status, Customer customer, List<OrderItem>orderItems) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.price = price;
		this.date = date;
		this.status = status;
		this.customer = customer;
		//this.product = product;
		this.orderItems=orderItems;
	}


public Orders() {
}

public int getOrderId() {
    return orderId;
}

public void setOrderId(int orderId) {
    this.orderId = orderId;
}

public int getQuantity() {
    return quantity;
}

public void setQuantity(int quantity) {
    this.quantity = quantity;
}

public int getPrice() {
    return price;
}

public void setPrice(int price) {
    this.price = price;
}

public String getDate() {
    return date;
}

public void setDate(String date) {
    this.date = date;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}
public Customer getCustomer() {
    return customer;
}

public void setCustomer(Customer customer) {
    this.customer = customer;
}

/*
 * public Product getProduct() { return product; }
 * 
 * public void setProduct(Product product) { this.product = product; }
 */

public List<OrderItem> getOrderItems() {
	return orderItems;
}


public void setOrderItems(List<OrderItem> orderItems) {
	this.orderItems = orderItems;
}


/* 
public List<Orders> getOrders() {
    return Orders;
}

public void setOrders(List<Orders> orders) {
    Orders = orders;
}
*/

// public int getCustomerId() {
//     return customerId;
// }

// public void setCustomerId(int customerId) {
//     this.customerId = customerId;
// }
}
