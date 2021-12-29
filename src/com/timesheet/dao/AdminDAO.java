package com.timesheet.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.timesheet.interfaces.AdminDAOInterface;
import com.timesheet.module.User;

public class AdminDAO implements AdminDAOInterface
{
	public User validateAdmin(String username,String password)
	{
		String checkquery="select * from user_details where role='ADMIN'and user_name='"+username+"'and password='"+password+"'";
		Connection con=Connectionutil.getDbConnection();
		 User user=null;
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(checkquery);
			if(rs.next())
			{
				user=new User(rs.getString(2),rs.getString(3), username,password);
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			System.out.println("Statement error");
		}
		
	return user;
		
	}
	}
	
