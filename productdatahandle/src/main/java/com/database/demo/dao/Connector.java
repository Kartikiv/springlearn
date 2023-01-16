package com.database.demo.dao;

import java.util.List;

import com.database.demo.entity.Products;

public interface Connector {
public int save(Products p);
public int deleteById(long l);
public List<Products> getAll();
public int updateByID(Products p);
public Products getById(long l);
}
