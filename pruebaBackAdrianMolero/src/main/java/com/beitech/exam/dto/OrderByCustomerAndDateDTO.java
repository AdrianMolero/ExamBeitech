package com.beitech.exam.dto;

import java.util.List;

import com.beitech.exam.entity.Order;
import com.beitech.exam.entity.OrderDetail;

import lombok.Data;

@Data
public class OrderByCustomerAndDateDTO {
	private Order order;
	private List<OrderDetail> orderDetail;
}
