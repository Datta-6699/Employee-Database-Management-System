package com.tap.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.UserDao;
import com.tap.Model.User;

public class UserDaoImp implements UserDao
{

	public List<User> getAllUser() {
     
		String query = "select * from users;";
		
		List<User> al = new ArrayList<>();
		
		try
		{
			Connection con = Connector.requestConnection();
			Statement stat = con.createStatement();
			ResultSet res = stat.executeQuery(query);
			
			while(res.next())
			{
				     int userId = res.getInt(1);
				     String fullName = res.getString(2);
				     String emailId = res.getString(3);
				     String phone = res.getString(4);
				     String password = res.getString(5);
				     
				     User u = new User(userId,fullName,emailId,phone,password);
				    
				     al.add(u);
				
			}
			
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		
			return al;
	}

	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertUser(User user)
	{
        String query = "INSERT INTO users (full_name, email, phone, password) VALUES (?, ?, ?, ?)";
        
        try
		{
			Connection con = Connector.requestConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, user.getFullName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPhone());
            pstmt.setString(4, user.getPassword()); 
            
            return pstmt.executeUpdate();
		}
        catch (Exception e) {
			e.printStackTrace();
		}
        
        return 0;
            
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(int user) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
   
}
