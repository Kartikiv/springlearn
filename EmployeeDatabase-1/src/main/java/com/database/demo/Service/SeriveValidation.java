package com.database.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.stereotype.Service;

import com.database.demo.Beans.Products;
import com.database.demo.dao.NameParamJDBC;

@Service
public class SeriveValidation {
@Autowired
NameParamJDBC connector;
	public int insertPrd(Products p) {
		
		return connector.insertPrd(p);
	}
public int updatePrd(Products p) {
		
		return connector.updatePrd(p) ;
	}
public Object delete(Products p) {
	  return connector.delete(p);
}
public Object getall() {
	  return connector.getall();
}
}
