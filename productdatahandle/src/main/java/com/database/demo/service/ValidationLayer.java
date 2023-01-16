package com.database.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.database.demo.dao.Connector;
import com.database.demo.entity.Products;
@Service
public class ValidationLayer implements Validations {
	@Autowired
	Connector con;

	@Override
	public ResponseEntity<Object> saveprd(Products p) {
		String name = p.getName();
		name = name.trim();
		p.setName(name);
		String namString = p.getSeller();
		namString = namString.trim();
		p.setSeller(namString);
		if (p.getName() == null || p.getName().equals("") || p.getName().isEmpty()) {
			return new ResponseEntity<Object>("Name Paramenter Invalid", HttpStatus.BAD_REQUEST);
		}
		if (p.getPrice() == 0 || p.getPrice() < 0 || p.getPrice() > 120000) {
			return new ResponseEntity<Object>("Price Paramenter Invalid", HttpStatus.BAD_REQUEST);
		}
		if (p.getSeller() == null || p.getSeller().equals("") || p.getSeller().isEmpty()) {
			return new ResponseEntity<Object>("Seller Paramenter Invalid", HttpStatus.BAD_REQUEST);
		}
		int rowEffected = con.save(p);
		return new ResponseEntity<Object>(rowEffected, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Object> getAll() { 
		List<Products> list = con.getAll();
		if (list.isEmpty()) {
			return new ResponseEntity<Object>("Empty database", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> updateprd(Products p) {
		if (p.getName() == null || p.getName().equals("") || p.getName().isEmpty()) {
			return new ResponseEntity<Object>("Name Paramenter Invalid", HttpStatus.BAD_REQUEST);
		}
		if (p.getPrice() == 0 || p.getPrice() < 0 || p.getPrice() > 120000) {
			return new ResponseEntity<Object>("Price Paramenter Invalid", HttpStatus.BAD_REQUEST);
		}
		String name = p.getName();
		name = name.trim();
		p.setName(name);
		String namString = p.getSeller();
		namString = namString.trim();
		p.setSeller(namString);
		
		try {
			con.getById(p.getId());
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<Object>("Empty  id", HttpStatus.NO_CONTENT);
		}
		con.updateByID(p);
		return new ResponseEntity<Object>(p, HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<Object> getById(long l) {
		try {
			Products p=con.getById(l);
			return new ResponseEntity<Object>(p, HttpStatus.ACCEPTED);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<Object>("Empty database", HttpStatus.NO_CONTENT);
		}
		
	}

	@Override
	public ResponseEntity<Object> delById(long l) {
		try {
			con.getById(l);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<Object>("Empty database id", HttpStatus.NO_CONTENT);
		}
		Integer effected=con.deleteById(l);
		 return new ResponseEntity<Object>(effected, HttpStatus.ACCEPTED);
	}

}
