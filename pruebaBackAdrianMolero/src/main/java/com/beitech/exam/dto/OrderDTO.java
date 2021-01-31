package com.beitech.exam.dto;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class OrderDTO {
	private Date creationDate;
	private Integer orderId;
	private Double total;
	private String delivery;
	private List<String> products;
}