package com.database.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.database.demo.entity.Products;

@Repository
public class JDBCConnector implements Connector {
	static String Insert = "insert into products (seller,name,stock_in_Inventory,id,created_date,price) values(?,?,?,?,?,?)";
	static String delete = "delete from products where id=?";
	static String showAll = "select * from Products";
	static String showById = "select * from products where id=?";
	static String update = "update products set name=? where id=?";

	@Autowired
	JdbcTemplate template;

	@Override
	public int save(Products p) {

		return template.update(Insert, new Object[] { p.getSeller(), p.getName(), p.getStockInInventory(), p.getId(),
				p.getCreatedDate(), p.getPrice() });
	}

	@Override
	public int deleteById(long id) {

		return template.update(delete, new Object[] { id });
	}

	@Override
	public List<Products> getAll() {

		return template.query(showAll, new BeanPropertyRowMapper<Products>(Products.class));
	}

	@Override
	public int updateByID(Products p) {

		return template.update(update, new Object[] { p.getName(), p.getId() });
	}

	@Override
	public Products getById(long id) {
		return template.queryForObject(showById, new BeanPropertyRowMapper<Products>(Products.class),
				new Object[] { id });
	}

}

class productrowmapper implements RowMapper<Products> {

	@Override
	public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
		Products p = new Products();
		p.setId(rs.getLong("id"));
		p.setName(rs.getString("name"));
		p.setCreatedDate(rs.getString("created_date"));
		p.setSeller(rs.getString(rs.getString("seller")));
		p.setPrice(rs.getDouble("price"));
		p.setStockInInventory(rs.getInt("stock_in_inventory"));
		return p;
	}

}
