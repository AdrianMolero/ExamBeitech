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

/**
 * The persistent class for the actividad_cronograma database table.
 * 
 */
@Entity
@Data
@Table(name="product")
@NamedQuery(name="Product.findAll", query="SELECT a FROM Product a")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private Integer productId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="product_description")
	private String productDescription;
	
	@Column(name="price")
	private Double price;

	public Product() {
	}

}