package com.demo.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderListDto implements Serializable{

	
	public OrderListDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@JsonProperty("orderList")
	List<OrderRequestDTO>orderDTOList=new ArrayList<OrderRequestDTO>();

	public OrderListDto(List<OrderRequestDTO> orderDTOList) {
		super();
		this.orderDTOList = orderDTOList;
	}

	public List<OrderRequestDTO> getOrderDTOList() {
		return orderDTOList;
	}

	public void setOrderDTOList(List<OrderRequestDTO> orderDTOList) {
		this.orderDTOList = orderDTOList;
	}

	@Override
	public String toString() {
		return "OrderListDto [orderDTOList=" + orderDTOList + ", getOrderDTOList()=" + getOrderDTOList()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
