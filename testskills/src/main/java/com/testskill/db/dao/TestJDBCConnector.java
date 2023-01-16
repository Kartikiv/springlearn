package com.testskill.db.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.testskill.db.entity.Test;
import com.testskill.db.events.TestTakenEvent;
@Repository
public class TestJDBCConnector {
	static String INSERT = "insert into test (id,email,marks,student_id) values(:id,:email,:marks,:student_id)";
@Autowired
NamedParameterJdbcTemplate template;
@Autowired
ApplicationEventPublisher publisher;
public Test save( Test s) {
	Test t= new Test();
	t.setId(s.getId());
	t.setEmail(s.getEmail());
	MapSqlParameterSource map = new MapSqlParameterSource();
	map.addValue("id", s.getId());
	map.addValue("email", s.getEmail());
     if(s.getMarks()==null) {
    	 s.setMarks(0l);
     }
	map.addValue("marks", s.getMarks());
	map.addValue("student_id", s.getId());
	template.update(INSERT, map);
	
	publisher.publishEvent(new TestTakenEvent(s));
	return s;
}
public List<Test> getAll(){
	return template.query("select * from test ", new BeanPropertyRowMapper<Test>(Test.class));
}
}
