package com.database.demo.service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.database.demo.dao.Jpainterf;
import com.database.demo.entity.NameList;
import com.database.demo.entity.Products;
import com.database.demo.entity.nameAllPresent;
import com.fasterxml.jackson.core.sym.Name;

import ch.qos.logback.classic.Logger;

@Service
public class ServiceValidation implements Valadations {
	final static org.jboss.logging.Logger logger = LoggerFactory.logger(ServiceValidation.class);
	@Autowired
	Jpainterf refApi;
	@Autowired
	nameAllPresent namelist;
	HashSet<String> hashSet = new HashSet<>();

	public boolean isNamePresent(String name) {
		logger.debug("Recieved a name " + name);
		List<Products> products = refApi.getAll();
		for (Products p : products) {
			hashSet.add(p.getName());
		}
		namelist.setNameList(hashSet);
		if (namelist.isPresentName(name)) {
			System.out.println(name + " is Already present");
			return true;
		}
		return false;
	}

	public ResponseEntity<Object> saveWithValidatinons(Products p) {
		long start = System.currentTimeMillis();
		logger.debug("Recieved products with data" + p);
		String name = p.getName();
		name = name.trim();
		p.setName(name);

		if (p.getName() == null || p.getDescription() == null || p.getPrice() == null) {
			System.out.println(p);
			System.out.println("wrong Input Please check");
			ResponseEntity<Object> k = new ResponseEntity<>(new ErrorListing(2), HttpStatus.BAD_REQUEST);
			long endtime = System.currentTimeMillis();
			logger.debug("time taken to add object to database but failed" + " " + (endtime - start));
			return k;
		}
		if (isNamePresent(p.getName())) {
			ResponseEntity<Object> k = new ResponseEntity<>(new ErrorListing(1), HttpStatus.BAD_REQUEST);
			long endtime = System.currentTimeMillis();
			logger.debug("time taken to add object to database but failed" + " " + (endtime - start));
			return k;

		}

		if (p.getPrice().compareTo(new BigDecimal(0)) < 0 || p.getPrice().compareTo(new BigDecimal(10000)) > 0) {
			ResponseEntity<Object> k = new ResponseEntity<>(new ErrorListing(3), HttpStatus.BAD_REQUEST);
			long endtime = System.currentTimeMillis();
			logger.debug("time taken to add object to database but failed" + " " + (endtime - start));
			return k;

		}
		if (p.getName() == null || p.getDescription() == null || p.getPrice().equals(new BigDecimal("0"))) {
			System.out.println(p);
			System.out.println("wrong Input Please check");
			ResponseEntity<Object> k = new ResponseEntity<>(new ErrorListing(2), HttpStatus.BAD_REQUEST);
			long endtime = System.currentTimeMillis();
			logger.debug("time taken to add object to database but failed" + " " + (endtime - start));
			return k;
		}

		if (p.getDescription() == "" || p.getName() == "") {
			System.out.println("wrong Input Please check");
			System.out.println(p);
			ResponseEntity<Object> k = new ResponseEntity<>(new ErrorListing(2), HttpStatus.BAD_REQUEST);
			long endtime = System.currentTimeMillis();
			logger.debug("time taken to add object to database but failed" + " " + (endtime - start));
			return k;
		}
		namelist.addName(p.getName());
		long endtime = System.currentTimeMillis();
		logger.debug("time taken to add object to database sucessfully" + " " + (endtime - start));
		return refApi.save(p);

	}

	public ResponseEntity<Object> getById(Long a) {
		long start = System.currentTimeMillis();
		Optional<Products> p = refApi.getById(a);
		if (!p.isEmpty()) {
			Products products = p.get();
			ResponseEntity<Object> k = new ResponseEntity<Object>(products, HttpStatus.ACCEPTED);
			long endtime = System.currentTimeMillis();
			logger.debug("time taken to get an object by id from database" + " " + (endtime - start));

			return k;
		} else {
			System.out.println("error no such element");
			ResponseEntity<Object> k = new ResponseEntity<>(new ErrorListing(2), HttpStatus.BAD_REQUEST);
			long endtime = System.currentTimeMillis();
			logger.debug("time taken to get an object by id from database but failed" + " " + (endtime - start));
			return k;

		}

	}

	public ResponseEntity<Object> getAll() {
		long start = System.currentTimeMillis();
		List<Products> idProduct = refApi.getAll();
		if (!idProduct.isEmpty()) {
			ResponseEntity<Object> listobjects = new ResponseEntity<>(idProduct, HttpStatus.ACCEPTED);
			long endtime = System.currentTimeMillis();
			logger.debug("time taken to shows  objects from  database" + " " + (endtime - start));
			return listobjects;
		} else {
			System.out.println("No Such Elemnts");
			ResponseEntity<Object> listobjects = new ResponseEntity<>(new ErrorListing(4), HttpStatus.BAD_REQUEST);
			long endtime = System.currentTimeMillis();
			logger.debug("time taken to shows  objects from  database but failed" + " " + (endtime - start));
			return listobjects;
		}
	}

	public ResponseEntity<Object> delValidation(Long a) {
		long start = System.currentTimeMillis();
		Optional<Products> p = refApi.getById(a);
		if (!p.isEmpty()) {

			refApi.delPrById(a);
			long endtime = System.currentTimeMillis();
			logger.debug("time taken to delete object from database" + " " + (endtime - start));
			return new ResponseEntity<Object>("passsed", HttpStatus.ACCEPTED);
		} else {
			long endtime = System.currentTimeMillis();
			logger.debug("time taken to delete object from database but failed" + " " + (endtime - start));
			return new ResponseEntity<Object>("no user present", HttpStatus.BAD_REQUEST);
		}

	}

	public ResponseEntity<Object> update(String name, Long id) {
		long start = System.currentTimeMillis();
		name = name.trim();
		System.out.println(getById(id));
		if (getById(id).getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
			System.out.println(getById(id));
			long endtime = System.currentTimeMillis();
			logger.debug("time taken to update an object to database but failed" + " " + (endtime - start));
			return new ResponseEntity<Object>("no user to update", HttpStatus.BAD_REQUEST);
		}
		if (name.equals("") || name == null || isNamePresent(name)) {
			long endtime = System.currentTimeMillis();
			logger.debug("time taken to update an object to database but failed" + " " + (endtime - start));
			return new ResponseEntity<Object>("cannot return empty name or conflicting name", HttpStatus.BAD_REQUEST);
		}
		Optional<Products> p = refApi.getById(id);
		namelist.deleteName(p.get().getName());
		namelist.addName(name);
		int a = refApi.update(name, id);
		long endtime = System.currentTimeMillis();
		logger.debug("time taken to update an object to database " + " " + (endtime - start));
		return new ResponseEntity<Object>(a, HttpStatus.ACCEPTED);
	}

}
