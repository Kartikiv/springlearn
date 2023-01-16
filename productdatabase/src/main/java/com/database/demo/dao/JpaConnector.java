package com.database.demo.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.patterns.HasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.database.demo.entity.Products;

import ch.qos.logback.classic.Logger;

@Repository
public class JpaConnector implements Jpainterf {
	final static org.jboss.logging.Logger logger = LoggerFactory.logger(JpaConnector.class);
	@Autowired
	ProductService service;

	@Override
	public ResponseEntity<Object> save(Products p) {

		Products savedProduct = service.save(p);
		ResponseEntity<Object> k = new ResponseEntity<>(savedProduct, HttpStatus.CREATED);

		return k;
	}

	@Override
	public List<Products> getAll() {

		return service.findAll();

	}

	@Override
	public void delPrById(long Id) {
		service.deleteById(Id);
	}

	@Override
	public Optional<Products> getById(Long id) {

		return service.findById(id);
	}

	@Override
	public int update(String name, Long id) {

		return service.update(name, id);
	}

}
