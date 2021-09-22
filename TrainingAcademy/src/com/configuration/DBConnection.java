package com.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static final String JDBC_URL = "jdbc:mysql://localhost/Training_Academy";
	public static final String USER = "root";
	public static final String PASS = "root";
	static Connection con = null;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// System.out.println("Driver Loaded");
			// System.out.println("Connecting to database....");
			con = DriverManager.getConnection(JDBC_URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	// public static void main(String[] args) {
	//
	// Connection con = DBConnection.getConnection();
	// if (con != null) {
	// System.out.println("Connection Successfull");
	// } else {
	// System.out.println("Connection Failed");
	// }
	//
	// }

}
