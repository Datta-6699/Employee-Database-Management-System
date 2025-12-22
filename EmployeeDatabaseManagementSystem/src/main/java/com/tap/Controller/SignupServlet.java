package com.tap.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.DaoImp.UserDaoImp;
import com.tap.Model.User;

@WebServlet("/signupcall")
public class SignupServlet extends HttpServlet
{
   @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
   {
	   
	   String name = req.getParameter("username");
	   String email = req.getParameter("email");
	   String phone = req.getParameter("phone");
	   String password = req.getParameter("password");
	   String Id = "RAM"+phone.substring(5);
	   UserDaoImp userDaoImp = new UserDaoImp();
	   User user = new User(name,email,phone,password);
	   int n = userDaoImp.insertUser(user);
	   
	   if(n!=0)
	   {
	    RequestDispatcher rd = req.getRequestDispatcher("registrationsuccessful.jsp");
	    rd.forward(req, resp);
	   }
	   else
	   {
		   RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
		    rd.forward(req, resp); 
	   }
	    
	    
	      
   }
}
