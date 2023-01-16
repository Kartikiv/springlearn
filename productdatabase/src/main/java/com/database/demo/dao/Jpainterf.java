package com.database.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import com.database.demo.entity.Products;

public interface Jpainterf {
	public ResponseEntity<Object> save(Products p);
	public List<Products> getAll();
	public void delPrById(long Id);
	public Optional<Products> getById(Long id);
	
	
	public int update(String name,Long id);
}
