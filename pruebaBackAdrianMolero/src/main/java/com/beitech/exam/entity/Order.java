package com.beitech.exam.entity;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name="`order`")
@NamedQuery(name="Order.findAll", query="SELECT d FROM Order d")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private Integer orderId;
	
	@Column(name="customer_id")
	private Integer customerId;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="delivery_address")
	private String deliveryAddress;
	
	@Column(name="total")
	private Double total;
	
	
}
