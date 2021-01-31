package com.beitech.exam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="customer_product")
@NamedQuery(name="CustomerProduct.findAll", query="SELECT c FROM CustomerProduct c")
@IdClass(CustomerProductPK.class)
public class CustomerProduct {
	@Id
	@Column(name="customer_id", insertable=false, updatable=false)
	private Integer customerId;
	
	@Id
	@Column(name="product_id", insertable=false, updatable=false)
	private Integer productId;

	public CustomerProduct(Integer customerId, Integer productId) {
		super();
		this.customerId = customerId;
		this.productId = productId;
	}
	
	
}
