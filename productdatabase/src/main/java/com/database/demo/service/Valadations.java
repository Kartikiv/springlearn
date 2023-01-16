package com.database.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.database.demo.entity.Products;

public interface Valadations {
	public boolean isNamePresent(String name);
	public ResponseEntity<Object> saveWithValidatinons(Products p);
	public ResponseEntity<Object> getById(Long a) ;
	public ResponseEntity<Object> getAll();
	public ResponseEntity<Object> delValidation(Long a);
	public  ResponseEntity<Object> update(String name, Long id);

}
