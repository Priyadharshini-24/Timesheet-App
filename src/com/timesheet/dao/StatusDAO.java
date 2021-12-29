package com.timesheet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.timesheet.interfaces.StatusDAOInterface;
import com.timesheet.module.Status;
public class StatusDAO implements StatusDAOInterface
{
	 public void insertStatus(Status status)
	 {
		 String insertquery="insert into status(user_id,timesheet_id,status,approved_by)values(?,?,?,?)";
		 Connectionutil conutil=new Connectionutil();
			Connection con=conutil.getDbConnection();
			PreparedStatement pstmt=null;
			try
			{
				pstmt=con.prepareStatement(insertquery);
				pstmt.setInt(1,status.getUserid());
				pstmt.setInt(2,status.getTimesheetid());
				pstmt.setString(3,status.getStatus());
				pstmt.setString(4,status.getApprovedby());
				pstmt.executeUpdate();
				System.out.println("Status add successfully");
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				System.out.println("somthing went wrong");
			}
	 }
	 public void updateStatus(Status status)
	 {
		 String updatequery="update status set user_id=?,status=?,approved_by=? where timesheet_id=?";
		 Connection con=Connectionutil.getDbConnection();
			PreparedStatement pstmt=null;
			try
			{
				pstmt=con.prepareStatement(updatequery);
				pstmt.setInt(1,status.getUserid());
				pstmt.setString(2,status.getStatus());
				pstmt.setString(3,status.getApprovedby());
				pstmt.setInt(4,status.getTimesheetid());
				int i=pstmt.executeUpdate();
				System.out.println(i+" Status updated");
	          }
			catch(SQLException e)
			{
				e.printStackTrace();
				System.out.println("something went wrong");
			}
    }
	 public List<Status> showStatus()
	 {
		List<Status> statuslist =new ArrayList<Status>();
		String selectquery="select * from status";
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
			Status status=new Status(rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5));
			statuslist.add(status);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("somthing went wrong");
		}
		return statuslist; 
	 }
	public void removeStatus(int timesheetid)
	{
		String removequery="delete from status where timesheet_id=?";
		Connection con=Connectionutil.getDbConnection();
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(removequery);
		    pstmt.setInt(1,timesheetid);
		    int i=pstmt.executeUpdate();
            System.out.println(i+" Status Remove ");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("something went wrong");
		}
	}
}
