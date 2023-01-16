package com.database.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.database.demo.entity.Products;

public interface Validations {
	public  ResponseEntity<Object>  saveprd(Products p);
	public  ResponseEntity<Object>  getAll();
	public  ResponseEntity<Object>  updateprd(Products p);
	public  ResponseEntity<Object>  getById(long l);
	public ResponseEntity<Object> delById(long l) ;

}
