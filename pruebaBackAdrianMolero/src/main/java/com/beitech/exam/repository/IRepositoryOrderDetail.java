package com.beitech.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beitech.exam.entity.OrderDetail;

@Repository
public interface IRepositoryOrderDetail extends JpaRepository<OrderDetail, Integer> {
	@Query(value = "SELECT * FROM test.order_detail where order_id = ?1", nativeQuery = true)
	public List<OrderDetail> queryOrderDetailByOrder(@Param("IDORDER") Integer idOrder);
}
