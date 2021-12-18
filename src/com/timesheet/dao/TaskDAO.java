package com.timesheet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.timesheet.module.Task;

public class TaskDAO {
	public void insertTask(Task task)
	{
		String insertquery="insert into task_details(task_name,start_date,end_date,task_priority,assigned_to,assigned_date)values(?,?,?,?,?,?)";
		Connectionutil conutil=new Connectionutil();
		Connection con=conutil.getDbConnection();
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(insertquery);
			pstmt.setString(1, task.getTask());
			pstmt.setString(2, task.getStartdate());
			pstmt.setString(3, task.getEnddate());
			pstmt.setString(4, task.getTask_priority());
			pstmt.setString(5, task.getAssigned_to());
			pstmt.setString(6,task.getDate_assigned());
			pstmt.executeUpdate();
			System.out.println("Task add successfully");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Task not added");
		}
	}
	public static int findtaskId(Task task)
	{
		String findtask="SELECT TASK_ID TASK_DETAIL WHERE TASK_NAME= '"+task.getTask()+"'";
		Connection con=Connectionutil.getDbConnection();
		Statement stmt;
		int taskId=0;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(findtask);
			if(rs.next())
			{
			taskId=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taskId;
		
	}
	public void remove(Task task)
	{
		String removequery="DELETE TASK_DETAIL WHERE TASK_NAME= '"+task.getTask()+"'";
		Connection con=Connectionutil.getDbConnection();
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(removequery);
			pstmt.executeUpdate();
			System.out.println("Task Remove successfully");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Task not Removed");
		}
	}
	public void updateTask(Task task)
	{
	 String updatequery="UPDATE TASK_DETAIL SET TASK_NAME= '"+task.getTask()+"'WHERE TASK_ID='"+task.getStartdate()+"'";
	 Connection con=Connectionutil.getDbConnection();
	 PreparedStatement pstmt=null;
	 
	}
}
