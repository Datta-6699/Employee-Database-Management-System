package com.tap.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.DaoImp.EmployeeDaoImp;
import com.tap.Model.Employee;

@WebServlet("/CallServlet")

public class AddEmployeeServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("fullName");
	     String fathersName = req.getParameter("fathersName");
	     String dateOfBirth =  req.getParameter("dob");
	     String salary  = req.getParameter("salary");
	     String address =  req.getParameter("address");
	     String phoneNumber =  req.getParameter("phone");
	     String emailId =  req.getParameter("email");
	     String highestEducation  = req.getParameter("highestEducation");
	     String designation = req.getParameter("designation");
	     String aadharNo =  req.getParameter("aadharNo");
	     String employeeId = "EDMS"+dateOfBirth.substring(5,8)+phoneNumber.substring(6);
	     
	     Employee e = new Employee(employeeId,name,fathersName,dateOfBirth,Double.parseDouble(salary),address,phoneNumber,emailId,highestEducation,designation,aadharNo);
	     
	     EmployeeDaoImp emp= new EmployeeDaoImp();
	     
	     int val = emp.insertEmployee(e);
	     
	     if(val!=0)
	     {
	    	 RequestDispatcher rd = req.getRequestDispatcher("insertsucessful.jsp");
	    	 rd.forward(req, resp);
	     }
	     else
	     {
	    	 RequestDispatcher rd = req.getRequestDispatcher("addEmployee.jsp");
	    	 rd.forward(req, resp); 
	     }
		
	}
	
}
