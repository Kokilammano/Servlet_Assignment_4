package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.app.dbcon.DBConnection;
import com.app.employee.Employee;

public class EmployeeDAO {
	
	public Employee registerEmployee(Employee employee)throws ClassNotFoundException {
		String sql="INSERT INTO employdb(id,name,gender,role,location,havingpassport) VALUES(?,?,?,?,?,?)";
		Connection con=DBConnection.getConnection();
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getGender());
			ps.setString(4, employee.getRole());
			ps.setString(5, employee.getLocation());
			ps.setString(6, employee.getPassport());
			
			System.out.println(ps);
			int rs=ps.executeUpdate();
		}
		catch(Exception e1) {
			System.out.println(e1);
		}
		
		return employee;
		
	}

	
}
