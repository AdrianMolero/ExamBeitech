package com.beitech.exam.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beitech.exam.entity.CustomerProduct;

@Repository
public interface IRepositoryCustomerProduct extends CrudRepository<CustomerProduct, Integer> {
	
}
