package com.student.db.dao;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.student.db.entity.Students;





@Repository
public class StudentsRepo {
	String INSERT = "insert into students (id,date,name,marks,percentile)values(:id,:date ,:name,:marks,:percentile)";
	String GETBYID = "select * from students where id=:id";
	String DELETE = "delete from students  where id=:id";
	String UPDATE = "update students set name=:name,percentile=:percentile,marks=:marks,date=:date where id=:id";
	String ShowAll = "select * from students";
	String DOBRANGE = "select * from students where date between :startdate and :enddate  ";
	String MARKSRANGE = "select * from students where marks between :start and :end";
	@Autowired
	NamedParameterJdbcTemplate template;
	@Autowired
	ApplicationEventPublisher publisher;
	
	 
    @Transactional
	public Students save(Students s) {
    
		var rowsAffected = template.update(INSERT, new BeanPropertySqlParameterSource(s));
		if(s.getName().equals("kartik")) {
			throw new  RuntimeException("invalid");
		}
	
		publisher.publishEvent(new StudentRegister(s));
		return s;
	}

	public Students getById(long id) throws EmptyResultDataAccessException {
		SqlParameterSource namedParameters = new MapSqlParameterSource();
		((MapSqlParameterSource) namedParameters).addValue("id", id);
		return template.queryForObject(GETBYID, namedParameters, new BeanPropertyRowMapper<Students>(Students.class));
	}

	public Students updatePrd(Students p) {

		template.update(UPDATE, new BeanPropertySqlParameterSource(p));
		return p;
	}

	public int delete(long id) {
		SqlParameterSource namedParameters = new MapSqlParameterSource();
		((MapSqlParameterSource) namedParameters).addValue("id", id);
		return template.update(DELETE, namedParameters);
	}

	public List<Students> getall() {
		return template.query(ShowAll, new BeanPropertyRowMapper<Students>(Students.class));
	}

	public List<Students> dobRange(Date start, Date end) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("startdate", start);
		map.addValue("enddate", end);
		return template.query(DOBRANGE, map, new BeanPropertyRowMapper<Students>(Students.class));
	}

	public List<Students> marksRange(short start, short end) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("start", start);
		map.addValue("end", end);
		return template.query(MARKSRANGE, map, new BeanPropertyRowMapper<Students>(Students.class));
	}
}
