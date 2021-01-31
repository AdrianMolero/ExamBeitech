package com.beitech.exam.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beitech.exam.entity.Customer;

@Repository
public interface IRepositoryCustomer extends CrudRepository<Customer, Integer> {
	
}
