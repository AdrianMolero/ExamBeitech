package com.beitech.exam.dto;

import java.util.List;

import lombok.Data;

@Data
public class RequestCreateOrder {
	private Integer customerId;
	private String deliveryAddress;
	private Double total;
	private List<ProductCreateOrderAux> products;
}
