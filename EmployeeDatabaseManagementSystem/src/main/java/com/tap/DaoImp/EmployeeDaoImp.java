package com.tap.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.EmployeeDao;
import com.tap.Model.Employee;

public class EmployeeDaoImp implements EmployeeDao
{

	public List<Employee> getAllEmployee() 
	{
		String query = "select * from employee;";
		
		List<Employee> al = new ArrayList<>();
		
		try
		{
			Connection con = Connector.requestConnection();
			Statement stat = con.createStatement();
			ResultSet res = stat.executeQuery(query);
			
			while(res.next())
			{
				     String employeeId = res.getString(1);
				     String name = res.getString(2);
				     String fathersName = res.getString(3);
				     String dateOfBirth = res.getString(4);
				     double salary = res.getDouble(5);
				     String address = res.getString(6);
				     String phoneNumber = res.getString(7);
				     String emailId = res.getString(8);
				     String highestEducation = res.getString(9);
				     String designation = res.getString(10);
				     String aadharNo = res.getString(11);
				     
				Employee e = new Employee(employeeId,name,fathersName,dateOfBirth,salary,address,phoneNumber,emailId,highestEducation,designation,aadharNo);
				 
				al.add(e);
				
			}
			
			return al;
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	public Employee getEmployee(String employeeId)
	{
        String query = "select * from employee where employeeId = ?;";
			
		try
		{
			Connection con = Connector.requestConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,employeeId);
			ResultSet res = pstmt.executeQuery();
			
			res.next();
			
				     String employeeIdd = res.getString(1);
				     String name = res.getString(2);
				     String fathersName = res.getString(3);
				     String dateOfBirth = res.getString(4);
				     Double salary = res.getDouble(5);
				     String address = res.getString(6);
				     String phoneNumber = res.getString(7);
				     String emailId = res.getString(8);
				     String highestEducation = res.getString(9);
				     String designation = res.getString(10);
				     String aadharNo = res.getString(11);
				     
				Employee e = new Employee(employeeIdd,name,fathersName,dateOfBirth,salary,address,phoneNumber,emailId,highestEducation,designation,aadharNo);
				 
			
			return e;
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return new Employee();
	}

	public int insertEmployee(Employee employee) 
	{
	   
		String query = "INSERT INTO employee (employeeId ,Name, FathersName, DateOfBirth, Salary, Address, PhoneNumber, EmailID, HighestEducation, Designation, AadharNo)" 
		              +" VALUES(?,?,?,?,?,?,?,?,?,?,?);";
		try
		{
			Connection con = Connector.requestConnection();
			PreparedStatement res = con.prepareStatement(query);
			res.setString(1, employee.getEmployeeId());
			res.setString(2,employee.getName());
		    res.setString(3,employee.getFathersName());
            res.setString(4,employee.getDateOfBirth());
		    res.setDouble(5,employee.getSalary());
		    res.setString(6,employee.getAddress());
		    res.setString(7,employee.getPhoneNumber());
		    res.setString(8,employee.getEmailId());
		    res.setString(9,employee.getHighestEducation());
		    res.setString(10,employee.getDesignation());
		    res.setString(11,employee.getAadharNo());
			
		   return res.executeUpdate();	
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return 0;
			
	}


	public int updateEmployee(Employee employee)
	{
		String query = "UPDATE employee SET Name = ?, FathersName = ?, DateOfBirth = ?, Salary = ?, Address = ?, PhoneNumber = ?, EmailID = ?, HighestEducation = ?, Designation = ?, AadharNo = ? WHERE EmployeeID = ?";

	try
	{
		Connection con = Connector.requestConnection();
		PreparedStatement res = con.prepareStatement(query);
		
		res.setString(1,employee.getName());
	    res.setString(2,employee.getFathersName());
        res.setString(3,employee.getDateOfBirth());
	    res.setDouble(4,employee.getSalary());
	    res.setString(5,employee.getAddress());
	    res.setString(6,employee.getPhoneNumber());
	    res.setString(7,employee.getEmailId());
	    res.setString(8,employee.getHighestEducation());
	    res.setString(9,employee.getDesignation());
	    res.setString(10,employee.getAadharNo());
	    res.setString(11, employee.getEmployeeId());
		
		
	   return res.executeUpdate();	
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	
	return 0;
		
	}

	public int deleteEmployee(String employeeId)
	{
		String query = "delete from employee where employeeId = ?";
		try
		{
			Connection con = Connector.requestConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,employeeId);
			return pstmt.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return 0;
	}

	

}
