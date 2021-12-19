package com.timesheet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.timesheet.module.Status;
public class StatusDAO {
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
	 public void updatestatus(String status,int timesheetid)
	 {
		 String updatequery="update status set status=? where timesheet_id=?";
		 Connection con=Connectionutil.getDbConnection();
			PreparedStatement pstmt=null;
			try
			{
				pstmt=con.prepareStatement(updatequery);
				pstmt.setString(1,status);
				pstmt.setInt(2,timesheetid);
				int i=pstmt.executeUpdate();
				System.out.println(i+" Status updated");
	          }
			catch(SQLException e)
			{
				e.printStackTrace();
				System.out.println("something went wrong");
			}

    }
}
