//Coding for database connection

package com.app.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No such driver exists");
			System.exit(0);
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","kokilam");
		} catch (SQLException e) {
			System.out.println("SQL Exception:");
		}
		return con;
		
	}
}
