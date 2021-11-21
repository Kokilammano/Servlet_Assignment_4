
package com.app.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.EmployeeDAO;
import com.app.employee.Employee;


@WebServlet("/getEmploy")
public class GetEmployServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDAO;
	
	public void init() {
		employeeDAO=new EmployeeDAO();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String role=request.getParameter("role");
		String location=request.getParameter("location");
		String passport=request.getParameter("passport");

		if(passport==null) {
			passport="No";
		}
		else {
			passport="Yes";
		}
		

		Employee employee=new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setGender(gender);
		employee.setRole(role);
		employee.setLocation(location);
		employee.setPassport(passport);
		
		try {
			employeeDAO.registerEmployee(employee);
			System.out.println("Inserted Successfully");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
