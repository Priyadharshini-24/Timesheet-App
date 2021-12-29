package com.timesheet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.timesheet.interfaces.UserDAOInterface;
import com.timesheet.module.User;

public class UserDAO implements UserDAOInterface 
{
	public void insertUser(User user)
	{
		String insertquery="insert into user_details(first_name,last_name,user_name,password)values(?,?,?,?)";
		Connectionutil conutil=new Connectionutil();
		Connection con=conutil.getDbConnection();
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(insertquery);
			pstmt.setString(1, user.getFirstname());
			pstmt.setString(2, user.getLastname());
			pstmt.setString(3, user.getUsername());
			pstmt.setString(4, user.getPassword());
			pstmt.executeUpdate();
			System.out.println("value insert successfully");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("somthing went wrong");
		}
	}
	
	public User validateUser(String username,String password)
	{
		String validatequery="select * from user_details where role='TEAM MEMBER'and user_name='"+username+"'and password='"+password+"'";
		Connection con=Connectionutil.getDbConnection();
		User user=null;
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(validatequery);
			if(rs.next())
			{
				user=new User(rs.getString(2),rs.getString(3), username,password );
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			System.out.println("Statement error");
		}
		return user;
		
	}
	public void updateUser(User user)
	{
		String updatequery="update user_details set first_name=?,last_name=?,password=? where user_name=?";
		Connection con=Connectionutil.getDbConnection();
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(updatequery);
			pstmt.setString(1, user.getFirstname());
			pstmt.setString(2, user.getLastname());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getUsername());
			int i=pstmt.executeUpdate();
			System.out.println(i+" user profile updated");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("something went wrong");
		}
	}
	

	public List<User> showalluser()
	{
		List<User> userlist=new ArrayList<User>();
		String selectquery="select * from user_details where role='TEAM MEMBER'";
		Connectionutil conutil=new Connectionutil();
		Connection con=conutil.getDbConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{
			pstmt=con.prepareStatement(selectquery);	
			rs=pstmt.executeQuery();
		while(rs.next())
		{
			User user=new User(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			userlist.add(user);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("somthing went wrong");
		}
		
		return userlist;
		
	}
	public void removeUser(String username)
	{
		String removequery="delete from user_details where user_name=?";
		Connection con=Connectionutil.getDbConnection();
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(removequery);
			pstmt.setString(1,username);
			int i=pstmt.executeUpdate();
			System.out.println(i+" User details Remove ");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("something went wrong");
		}
	}
	public int findUserId(String username)
	{
		String findUser="select user_id from user_details where user_name= '"+username+"'";
		Connection con=Connectionutil.getDbConnection();
		Statement stmt;
		int userId=0;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(findUser);
			if(rs.next())
			{
			userId=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userId;
		
	}
}
