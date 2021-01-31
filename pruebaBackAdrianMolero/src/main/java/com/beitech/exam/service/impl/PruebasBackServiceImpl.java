package com.beitech.exam.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beitech.exam.dto.OrderByCustomerAndDateDTO;
import com.beitech.exam.dto.ProductCreateOrderAux;
import com.beitech.exam.dto.RequestCreateOrder;
import com.beitech.exam.dto.ResponseOrderByCustomerAndDateDTO;
import com.beitech.exam.entity.Order;
import com.beitech.exam.entity.OrderDetail;
import com.beitech.exam.entity.Product;
import com.beitech.exam.repository.IRepositoryOrder;
import com.beitech.exam.repository.IRepositoryOrderDetail;
import com.beitech.exam.repository.IRepositoryProduct;
import com.beitech.exam.service.PruebasBackService;
import com.beitech.exam.util.MapperUtil;

@Service
public class PruebasBackServiceImpl implements PruebasBackService{
	@Autowired
	private IRepositoryOrder repositoryOrder;
	
	@Autowired
	private IRepositoryOrderDetail repositoryOrderDetail;
	
	@Autowired 
	private IRepositoryProduct repositoryProduct;
	
	@Override
	public ResponseOrderByCustomerAndDateDTO getListOrdersByDateRange(Integer idCustomer, LocalDate initDate, LocalDate finalDate) {
		List<Order> responseQueryOrder = new ArrayList<Order>();	
		responseQueryOrder = repositoryOrder.queryOrdersByDateRange(idCustomer, initDate, finalDate);
		List<OrderByCustomerAndDateDTO> listOrderDTO = new ArrayList<OrderByCustomerAndDateDTO>();
		
		if(responseQueryOrder != null && !responseQueryOrder.isEmpty()) {
			for (Order order : responseQueryOrder) {
				OrderByCustomerAndDateDTO orderDTO = new OrderByCustomerAndDateDTO();
				orderDTO.setOrder(order); 
				
				
				List<OrderDetail> responseQueryOrderDetail = new ArrayList<OrderDetail>();	
				responseQueryOrderDetail = repositoryOrderDetail.queryOrderDetailByOrder(order.getOrderId());
				if(responseQueryOrderDetail != null && !responseQueryOrderDetail.isEmpty()) {
					orderDTO.setOrderDetail(responseQueryOrderDetail);
					listOrderDTO.add(orderDTO);
				}
			}
		}
		return MapperUtil.orderEntityToDto(listOrderDTO);
	}

	@Override
	public Boolean createOrder(RequestCreateOrder request) {
		try {
			if(request.getProducts().size() <= 5) {
				int cont = 0;
				for (ProductCreateOrderAux products : request.getProducts()) {
					cont += products.getQuantity();
				}
				
				if(cont <= 5) {
					Order order = MapperUtil.requestOrderToEntity(request);
					Order orderSaved = repositoryOrder.save(order);
					List<Product> listProductOrderDetail = new ArrayList<Product>();
					
					for (ProductCreateOrderAux products : request.getProducts()) {
						Product productOrderDetail = new Product();
						productOrderDetail = repositoryProduct.queryProduct(products.getProductId());
						listProductOrderDetail.add(productOrderDetail);
					}
					
					List<OrderDetail> orderDetail = new ArrayList<OrderDetail>();
					orderDetail = MapperUtil.requestOrderDetailToEntity(request, listProductOrderDetail, orderSaved.getOrderId());
					repositoryOrderDetail.saveAll(orderDetail);
				}else {
					return false;
				}
			}else {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
}
