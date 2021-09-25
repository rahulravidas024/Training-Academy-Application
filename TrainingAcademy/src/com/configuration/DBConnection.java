package com.configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static final String JDBC_URL = "jdbc:mysql://localhost/Training_Academy";
	public static final String USER = "root";
	public static final String PASS = "root";
	static Connection con = null;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
