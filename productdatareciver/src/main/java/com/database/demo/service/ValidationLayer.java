package com.database.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.database.demo.pojo.product;
import com.database.demo.restcaller.Caller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class ValidationLayer implements Validations {
	@Autowired
	Caller con;

	@Override
	public ResponseEntity<Object> getAll() {
		List<product> list;
		try {
			list = con.getAll();
			if (list == null) {
				return new ResponseEntity<Object>("Empty database", HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<Object>(list, HttpStatus.ACCEPTED);

		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseEntity<Object> save(product p) {
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
		con.save(p);
		return new ResponseEntity<Object>("Accepted", HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<Object> update(product p) {
		try {
			product p1 = con.getById(p.getId());
			if (p1 == null) {
				return new ResponseEntity<Object>("Empty database id", HttpStatus.NO_CONTENT);
			}
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<Object>("Empty database id", HttpStatus.NO_CONTENT);
		}
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

		con.update(p);
		return new ResponseEntity<Object>(p, HttpStatus.ACCEPTED);

	}

	@Override
	public ResponseEntity<Object> getById(Long id) {
		try {
			product p = con.getById(id);
			return new ResponseEntity<Object>(p, HttpStatus.ACCEPTED);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<Object>("Empty database", HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<Object> delete(long id) {

		try {
			product p1=con.getById(id);
			if (p1 == null) {
				return new ResponseEntity<Object>("Empty database id", HttpStatus.NO_CONTENT);
			}
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<Object>("Empty database id", HttpStatus.NO_CONTENT);
		}
		con.delete(id);
		return new ResponseEntity<Object>("Deleted", HttpStatus.ACCEPTED);

	}

}
