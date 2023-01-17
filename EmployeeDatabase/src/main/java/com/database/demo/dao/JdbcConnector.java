package com.database.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.database.demo.entity.Employee;

@Repository
public class JdbcConnector {
	static String SAVE_EMP="insert into employee(id,age,name,salary) values(?,?,?,?)";
	String Show_EMP="select* from employee where id=?";
	@Autowired
	JdbcTemplate connection;
	
public int updateemp(Employee e) {
	return connection.update(SAVE_EMP, new Object[] {e.getId(),e.getAge(),e.getName(),e.getSalary()});
}
public Employee getByIdEmp(Integer id) {
	return connection.queryForObject(Show_EMP, new BeanPropertyRowMapper<Employee>(Employee.class), new Object[] {id});
	
}

}
