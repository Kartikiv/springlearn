package com.database.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.database.demo.Beans.Products;

@Repository
public class NameParamJDBC  {
@Autowired
NamedParameterJdbcTemplate namedParameterJdbcTemplate;
static String Insert="insert into products (name,id,desp)values(:name,:id,:desp)";
static String UPDATE="update products set name=:name where id=:id";
static String Delete="delete from products  where id=:id";
static String ShowAll="select * from products";
	public int insertPrd(Products p) {
		
		return namedParameterJdbcTemplate.update(Insert, new BeanPropertySqlParameterSource(p)) ;
	}
public int updatePrd(Products p) {
		
		return namedParameterJdbcTemplate.update(UPDATE, new BeanPropertySqlParameterSource(p)) ;
	}
public Object delete(Products p) {
	  return namedParameterJdbcTemplate.update(Delete, new BeanPropertySqlParameterSource(p));
}
public List<Products> getall() {
	  return namedParameterJdbcTemplate.query(ShowAll, new BeanPropertyRowMapper<Products>());
}

}
