package com.beitech.exam.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseOrderByCustomerAndDateDTO {
	List<OrderDTO> responseOrder;
}
