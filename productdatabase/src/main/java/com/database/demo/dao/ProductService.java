package com.database.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.database.demo.entity.Products;

public interface ProductService extends JpaRepository<Products, Long> {
	@Transactional
	@Modifying(clearAutomatically = true ,flushAutomatically = true)
	@Query("update from Products p set p.name=?1 where p.id=?2")
	public int update(String name,Long id);


}
