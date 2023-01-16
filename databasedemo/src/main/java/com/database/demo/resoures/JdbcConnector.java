package com.database.demo.resoures;




import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.database.demo.enties.Students;



@Repository
public class JdbcConnector {
String Appl_pp="insert into Students(id,name,joining_date,rollno) values(?,?,?,?)";
String dell_pp="delete from Students where id=?";
String show_pp="select * from Students";
String Show_usr="select* from students where id=?";
String UPP_PPL="update students set name =?,rollno=?,joining_date=? where id=?";
	@Autowired
	JdbcTemplate studentcon;
	public int saveStud(Students stu) {
		return studentcon.update(Appl_pp,new Object[] {stu.getId(),stu.getName(),stu.getJoiningDate(),stu.getRollno()});
		
	}
	public int delStud(Integer s1) {
		return studentcon.update(dell_pp,new Object[] {s1});
		
	} 
	public List<Students> showstudent(){
		
		return studentcon.query(show_pp, new studentrowm());


	}
	public Students showuserById(Integer id){
		return studentcon.queryForObject(Show_usr,new BeanPropertyRowMapper<Students>(Students.class),new Object[] {
		id});	 
		
	}
	public List<Students> showuserById1(Integer id){
		return studentcon.query(Show_usr,new studentrowm(),new Object[] {id});
		 
		
	}
	public void updatestudents(Students a) {
	      
		 studentcon.update(UPP_PPL,new Object[] {a.getName(),a.getRollno(),a.getJoiningDate(),a.getId()});
		
	}

}
class studentresextractor implements ResultSetExtractor<Students>{

	@Override
	@Nullable
	public Students extractData(ResultSet rs) throws SQLException, DataAccessException {
		Students s=new Students();
		s.setId(rs.getInt("id"));
		s.setName(rs.getString("name"));
		s.setJoiningDate(rs.getString("joining_date"));
		s.setRollno(rs.getString("rollno"));
		
		return s;
	}
	
}
class studentrowm implements RowMapper<Students> {

	@Override
	@Nullable
	public Students mapRow(ResultSet rs, int rowNum) throws SQLException {
		Students s=new Students();
		s.setId(rs.getInt("id"));
		s.setName(rs.getString("name"));
		s.setJoiningDate(rs.getString("joining_date"));
		s.setRollno(rs.getString("rollno"));
		
		return s;
	}

	



}

