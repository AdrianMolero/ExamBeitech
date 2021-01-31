package com.beitech.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beitech.exam.entity.Product;

@Repository
public interface IRepositoryProduct extends JpaRepository<Product, Integer> {
	@Query(value = "SELECT * FROM test.product WHERE product_id = ?1", nativeQuery = true)
	public Product queryProduct(@Param("IDPRODUCT") Integer productId);

}
