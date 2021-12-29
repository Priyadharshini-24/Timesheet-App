package com.timesheet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.timesheet.interfaces.TaskDAOInterface;
import com.timesheet.module.Task;
public class TaskDAO implements TaskDAOInterface
{
	public void insertTask(Task task)
	{
		String insertquery="insert into task_details(user_id,task_name,assigned_to_date,end_date,task_priority,assigned_to)values(?,?,?,?,?,?)";
		Connectionutil conutil=new Connectionutil();
		Connection con=conutil.getDbConnection();
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(insertquery);
			pstmt.setInt(1,task.getUserid());
			pstmt.setString(2,task.getTask());
			pstmt.setString(3,task.getDateassigned());
			pstmt.setString(4,task.getEnddate());
			pstmt.setString(5,task.getTaskpriority());
			pstmt.setString(6,task.getAssignedto());
			
			pstmt.executeUpdate();
			System.out.println("Task add successfully");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Task not added");
		}
	}
	public void updateTask(Task task)
	{
		String updatequery="update task_details set user_id=?,task_name=?,end_date=?,task_priority=?,assigned_to=? where assigned_to_date=?";
		Connection con=Connectionutil.getDbConnection();
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(updatequery);
			pstmt.setInt(1, task.getUserid());
			pstmt.setString(2, task.getTask());
			pstmt.setString(3,task.getEnddate());
			pstmt.setString(4,task.getTaskpriority());
			pstmt.setString(5,task.getAssignedto());
			pstmt.setString(6,task.getDateassigned());
			int i=pstmt.executeUpdate();
			System.out.println(i+" Task updated");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("something went wrong");
		}
	}
	public List<Task> showallTask()
	{
		List<Task> tasklist=new ArrayList<Task>();
		String selectquery="select * from task_details";
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
			Task task=new Task(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			tasklist.add(task);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("somthing went wrong");
		}
		
		return tasklist;
		
	}
	public  int findtaskId(String task)
	{
		String findtask="select task_id from task_details where task_name= '"+task+"'";
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
	public void removeTask(String task)
	{
		String removequery="delete from task_details where task_name=?";
		Connection con=Connectionutil.getDbConnection();
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(removequery);
			pstmt.setString(1,task);
			int i=pstmt.executeUpdate();
			System.out.println(i+" Task Remove successfully");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Task not Removed");
		}
	}
}
