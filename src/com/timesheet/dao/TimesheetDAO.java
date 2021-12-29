package com.timesheet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.timesheet.interfaces.TimesheetDAOInterface;
import com.timesheet.module.Timesheet;

public class TimesheetDAO implements TimesheetDAOInterface 
{
	public void insertTimesheet(Timesheet timesheet)
	{
		String insertquery="insert into timesheets(user_id,task_id,spend_time_hrs,comments,timesheet_for_date)values(?,?,?,?,?)";
		Connectionutil conutil=new Connectionutil();
		Connection con=conutil.getDbConnection();
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(insertquery);
			pstmt.setInt(1, timesheet.getUserid());
			pstmt.setInt(2, timesheet.getTaskid());
			pstmt.setInt(3, timesheet.getSpendtime());
			pstmt.setString(4,timesheet.getComments());
			pstmt.setString(5,timesheet.getTimesheetfordate());
			pstmt.executeUpdate();
			System.out.println("Timesheet Entered successfully");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("somthing went wrong");
		}
	}
	public void updateTimesheet(Timesheet timesheet)
	{
		String updatequery="update timesheets set user_id=?,task_id=?,spend_time_hrs=?,comments=? where timesheet_for_date=?";
		Connection con=Connectionutil.getDbConnection();
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(updatequery);
			pstmt.setInt(1, timesheet.getUserid());
			pstmt.setInt(2, timesheet.getTaskid());
			pstmt.setInt(3, timesheet.getSpendtime());
			pstmt.setString(4,timesheet.getComments());
			pstmt.setString(5,timesheet.getTimesheetfordate());
			pstmt.executeUpdate();
			int i=pstmt.executeUpdate();
			System.out.println(i+" Timesheet updated");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("something went wrong");
		}
	}
	public List<Timesheet> showTimesheet()
	{
		List<Timesheet> timesheetlist=new ArrayList<Timesheet>();
		String selectquery="select * from timesheets";
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
			Timesheet timesheet=new Timesheet(rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6));
			timesheetlist.add(timesheet);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("somthing went wrong");
		}
		
		return timesheetlist;
	}
	public void removeTimesheet(String timesheetfordate)
	{
		String removequery="delete from timesheets where timesheet_for_date=?";
		Connection con=Connectionutil.getDbConnection();
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(removequery);
		    pstmt.setString(1,timesheetfordate);
		    int i=pstmt.executeUpdate();
            System.out.println(i+" Timesheet Remove ");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("something went wrong");
		}
		}
	public  int findTimesheetId(String timesheetfordate)
	{
		String findUser="select timesheet_id from timesheets where timesheet_for_date='"+timesheetfordate+"'";
		Connection con=Connectionutil.getDbConnection();
		Statement stmt;
		int timesheetId=0;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(findUser);
			if(rs.next())
			{
			timesheetId=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return timesheetId;
		
	}
	}
	
	
	
