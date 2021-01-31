package com.beitech.exam.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beitech.exam.entity.Order;

@Repository
public interface IRepositoryOrder extends JpaRepository<Order, Integer> {
	@Query(value = "SELECT * FROM test.order WHERE customer_id = ?1 AND creation_date BETWEEN ?2 AND ?3", nativeQuery = true)
	public List<Order> queryOrdersByDateRange(@Param("IDCUSTOMER") Integer idCustomer, @Param("INITDATE") LocalDate initDate, @Param("FINALDATE") LocalDate finalDate);
}
