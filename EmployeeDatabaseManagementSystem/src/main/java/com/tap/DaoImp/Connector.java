package com.tap.DaoImp;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector 
{
	static final String url = "jdbc:mysql://localhost:3306/employeedatabasemanagementsystem";
	static final String username = "root";
	static final String password = "Undavalli@143";
	static  Connection con = null;
 	
  public static Connection requestConnection() throws Exception
  {
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  con = DriverManager.getConnection(url,username,password);
	  return con;

  }
}
