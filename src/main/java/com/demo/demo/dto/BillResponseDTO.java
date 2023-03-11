package com.demo.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class BillResponseDTO {

	private List<OrderItemDTO>listOrderItemsDtos=new ArrayList<OrderItemDTO>();

	
	
	
	public BillResponseDTO(List<OrderItemDTO> listOrderItemsDtos) {
		super();
		this.listOrderItemsDtos = listOrderItemsDtos;
	}

	public BillResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<OrderItemDTO> getListOrderItemsDtos() {
		return listOrderItemsDtos;
	}

	public void setListOrderItemsDtos(List<OrderItemDTO> listOrderItemsDtos) {
		this.listOrderItemsDtos = listOrderItemsDtos;
	}
	
	
}
