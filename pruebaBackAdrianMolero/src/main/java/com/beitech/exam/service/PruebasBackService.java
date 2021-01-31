package com.beitech.exam.service;

import java.time.LocalDate;

import com.beitech.exam.dto.RequestCreateOrder;
import com.beitech.exam.dto.ResponseOrderByCustomerAndDateDTO;

public interface PruebasBackService {
	public ResponseOrderByCustomerAndDateDTO getListOrdersByDateRange(Integer idCustomer, LocalDate initDate, LocalDate finalDate);
	
	public Boolean createOrder(RequestCreateOrder request);
}
