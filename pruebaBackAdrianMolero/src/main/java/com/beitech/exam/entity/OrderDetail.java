package com.beitech.exam.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="order_detail")
@NamedQuery(name="OrderDetail.findAll", query="SELECT e FROM OrderDetail e")
public class OrderDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_detail_id")
	private Integer orderDetailId;
	
	@Column(name="order_id")
	private Integer orderId;
	
	@Column(name="product_id")
	private Integer productId;
	
	@Column(name="product_description")
	private String productDescription;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="quantity")
	private Integer quantity;
}
