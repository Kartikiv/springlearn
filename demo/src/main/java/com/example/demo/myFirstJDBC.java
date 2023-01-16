package com.example.demo;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myFirstJDBC {
	private static Connection getcon() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/kar";
		String uname = "root";
		String password = "newrootpassword";
		return DriverManager.getConnection(url, uname, password);

	}

	@PostMapping("/userdel/{id}")
	public String deletefrom(@PathVariable("id") String usrname) throws ClassNotFoundException, SQLException {
		String query = "delete from marks where name='" + usrname + "'";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = getcon();
		Statement st = con.createStatement();
		try {
			st.executeUpdate(query);
			return "passed";

		} catch (SQLException e) {
			return "no such user check input";
		} finally {
			st.close();
			con.close();
		}

	}

	@PostMapping("/useradd/{id}/{id1}/{id2}")
	public String insertinto(@PathVariable("id") String name, @PathVariable("id1") String id,
			@PathVariable("id2") String marks) throws SQLException, ClassNotFoundException {
		String query = "insert into marks Values(" + id + ",'" + name + "'," + marks + ")";
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = getcon();
		Statement st = con.createStatement();
		try {
			int a = Integer.parseInt(marks);
			st.executeUpdate(query);
			return "passed";
		} catch (NumberFormatException e) {
			return e.toString();
		} catch (SQLException e) {
			return e.toString();
		} finally {
			st.close();
			con.close();
		}

	}

	@GetMapping("/showusr/{id}")
	public String nameret(@PathVariable("id") String a) throws SQLException, ClassNotFoundException {

		String query = "select *from marks where name=" + a;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = getcon();
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(query);
		try {
			rs.next();
			return rs.getString("marks") + " " + rs.getString("name") + " " + rs.getString("id");
		} catch (Exception e) {

			return "no data";
		} finally {
			rs.close();
			st.close();
			con.close();
		}

	}

	@GetMapping("/showtable")
	public ArrayList<String> retrn() throws ClassNotFoundException, SQLException {
		ArrayList<String> kar = new ArrayList<>();

		String query = "select *from marks ";
		// String query1="insert Ignore into marks Values(10,'mard',11)";
		// String query2="delete from marks where name='mard'";
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = getcon();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		// st.executeUpdate(query1);
		try {

			while (rs.next()) {
				String name = rs.getString("marks") + "| " + rs.getString("Name") + " |" + rs.getString("id");
				kar.add(name);
			}

			return kar;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			rs.close();
			st.close();
			con.close();
		}

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(getcon());

	}

}
