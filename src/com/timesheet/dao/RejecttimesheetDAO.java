package com.timesheet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.timesheet.module.Rejecttimesheet;
public class RejecttimesheetDAO {
	public List<Rejecttimesheet> showRejecttimesheet()
	 {
		List<Rejecttimesheet> statuslist =new ArrayList<Rejecttimesheet>();
		String selectquery="select t.timesheet_id,t.task_id,t.timesheet_for_date,t.spend_time_hrs,s.status from (status s inner join timesheets t on s.timesheet_id=t.timesheet_id) where status='rejected'";
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
			Rejecttimesheet rejectTimesheet=new Rejecttimesheet(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5));
			statuslist.add(rejectTimesheet);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("somthing went wrong");
		}
		return statuslist; 
	 }

}
