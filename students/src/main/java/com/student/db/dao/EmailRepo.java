package com.student.db.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmailRepo {
	static String insert="Insert into email (id) values(:id)";
@Autowired
NamedParameterJdbcTemplate temp;
 public String save(String name) {
	 MapSqlParameterSource map=new MapSqlParameterSource();
	 map.addValue("id", name);
	 temp.update(insert,map );
	 return name;
	 
 }

}
