package com.testskill.db.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.testskill.db.entity.Students;

@Repository
public class JDBCConnectorStudents {
	static String INSERT = "insert into students (id,email,marks,name,percentile) values(:id,:email,:marks,:name,:percentile)";
	static String UPDATE="update students set name=:name,marks=:marks,percentile=:percentile,email=:email where id=:id";
	static String DELETE="delete from students where id=:id";
	static String GETBYID="select* from students where id=:id";
	static String GETALL="select * from students";
	@Autowired
	NamedParameterJdbcTemplate template;

	public Students save(Students s) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id", s.getId());
		map.addValue("email", s.getEmail());
		map.addValue("name", s.getName());
		map.addValue("marks", s.getMarks());
		map.addValue("percentile", s.getPercentile());

		template.update(INSERT, map);
		return s;
	}
	public Students update(Students s) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id", s.getId());
		map.addValue("email", s.getEmail());
		map.addValue("name", s.getName());
		map.addValue("marks", s.getMarks());
		map.addValue("percentile", s.getPercentile());
		template.update(UPDATE, map);
		return s;
	}
	public int delete(Long id) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id", id);
		 return template.update(DELETE,map );
	}
	public Students getByID(Long id) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id", id);
	   return  template.queryForObject(GETBYID, map, new BeanPropertyRowMapper<Students>(Students.class));
	}
	public List<Students> getAll(){
		return template.query(GETALL, new BeanPropertyRowMapper<Students>(Students.class));
	}
}
