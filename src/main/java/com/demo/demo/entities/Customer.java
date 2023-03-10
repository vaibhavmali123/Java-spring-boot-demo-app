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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer_table")
public class Customer implements Serializable{
 
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name="customer_id")   
private int customerId;

@Column(name="name")   
private String name;

@Column(name="mobileNo")   
private String mobileNo;

@Column(name="address")   
private String address;

/*
 * @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY,orphanRemoval
 * = true) List<Orders>Orders;
 */
/*
 * public List<Orders> getOrders() { return Orders; }
 */
/*
 * public void setOrders(List<Orders> orders) { Orders = orders; }
 */



public Customer() {
}

public Customer(int customerId, String name, String mobileNo, String address) {
    this.customerId = customerId;
    this.name = name;
    this.mobileNo = mobileNo;
    this.address = address;
}

public int getId() {
    return customerId;
}

public void setId(int id) {
    this.customerId = id;
}

public String getname() {
    return name;
}

public void setname(String name) {
    this.name = name;
}

public String getMobileNo() {
    return mobileNo;
}

public void setMobileNo(String mobileNo) {
    this.mobileNo = mobileNo;
}

public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address = address;
}






}
