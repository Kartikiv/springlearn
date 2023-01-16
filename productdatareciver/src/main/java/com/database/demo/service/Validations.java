package com.database.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.database.demo.pojo.product;

public interface Validations {
	public ResponseEntity<Object> getAll();

	public ResponseEntity<Object> save(product p);

	public ResponseEntity<Object> update(product p);

	public ResponseEntity<Object> getById(Long id);

	public ResponseEntity<Object> delete(long id);
}
