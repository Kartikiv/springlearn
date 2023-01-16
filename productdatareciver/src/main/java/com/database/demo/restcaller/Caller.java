package com.database.demo.restcaller;

import java.util.List;

import com.database.demo.pojo.product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface Caller {
	public List<product> getAll() throws JsonMappingException, JsonProcessingException;

	public void save(product p);

	public void update(product p);

	public product getById(Long id);

	public void delete(long id);

}
