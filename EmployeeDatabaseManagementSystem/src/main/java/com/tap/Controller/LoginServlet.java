package com.tap.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.DaoImp.UserDaoImp;
import com.tap.Model.User;

@WebServlet("/logincall")
public class LoginServlet extends HttpServlet
{
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
   {
	   UserDaoImp userDaoImp = new UserDaoImp();
	   List<User> list = userDaoImp.getAllUser();
	   String email = req.getParameter("email");
	   String password = req.getParameter("password");

	   boolean b = false;
	   
	   for(User user : list)
	   {
		   if(user.getEmail().equals(email) && user.getPassword().equals(password))
		   {
			   b = true;
			   
			   String userName = user.getFullName();
			   
			    HttpSession session = req.getSession();
			   
			    session.setAttribute("userName", userName);;
			   
			   RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
			   rd.forward(req, resp);
		   }
	   }
	   
	   if(b==false)
	   {
	   RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
	   rd.forward(req, resp);
	   }
	   
   }
}
