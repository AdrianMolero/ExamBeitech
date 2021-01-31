package com.beitech.exam.util;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.beitech.exam.dto.OrderByCustomerAndDateDTO;
import com.beitech.exam.dto.OrderDTO;
import com.beitech.exam.dto.RequestCreateOrder;
import com.beitech.exam.dto.ResponseOrderByCustomerAndDateDTO;
import com.beitech.exam.entity.Order;
import com.beitech.exam.entity.OrderDetail;
import com.beitech.exam.entity.Product;

public class MapperUtil {
	public static ResponseOrderByCustomerAndDateDTO orderEntityToDto(List<OrderByCustomerAndDateDTO> queryData) {
		List<OrderDTO> orderDTO = new ArrayList<OrderDTO>();
		
		for (OrderByCustomerAndDateDTO request : queryData) {
			OrderDTO orderContent = new OrderDTO();
			
			orderContent.setCreationDate(request.getOrder().getCreationDate());
			orderContent.setDelivery(request.getOrder().getDeliveryAddress());
			orderContent.setOrderId(request.getOrder().getOrderId());
			orderContent.setTotal(request.getOrder().getTotal());
			List<String> orderDetailContent = new ArrayList<String>();
			for (OrderDetail orderDetail : request.getOrderDetail()) {
				orderDetailContent.add(orderDetail.getQuantity() + " x " + orderDetail.getProductDescription());
			}
			orderContent.setProducts(orderDetailContent);
			orderDTO.add(orderContent);
		}
		return new ResponseOrderByCustomerAndDateDTO(orderDTO);
	}
	
	public static Order requestOrderToEntity(RequestCreateOrder request) {
		Order order = new Order();
		order.setCreationDate(Date.valueOf(LocalDate.now()));
		order.setCustomerId(request.getCustomerId());
		order.setDeliveryAddress(request.getDeliveryAddress());
		order.setTotal(request.getTotal());
		return order;
	}
	
	public static List<OrderDetail> requestOrderDetailToEntity(RequestCreateOrder request, List<Product> listProductOrderDetail, Integer orderId) {
		List<OrderDetail> listOrderDetail = new ArrayList<OrderDetail>();
		int cont = 0;
		for (Product product : listProductOrderDetail) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrderId(orderId);
			orderDetail.setPrice(product.getPrice());
			orderDetail.setProductDescription(product.getProductDescription());
			orderDetail.setProductId(product.getProductId());
			orderDetail.setQuantity(request.getProducts().get(cont).getQuantity());
			cont++;
			listOrderDetail.add(orderDetail);
		}
		
		return listOrderDetail;
	}
}
