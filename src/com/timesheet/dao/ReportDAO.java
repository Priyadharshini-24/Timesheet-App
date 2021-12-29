package com.timesheet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.timesheet.interfaces.ReportDAOInterface;
import com.timesheet.module.Report;

public class ReportDAO implements ReportDAOInterface {
	
	public List<Report> findreport(String timesheetdate,String username)
	{
		List<Report> reportlist=new ArrayList<Report>();
		String query="select u.user_name,u.role,td.task_name,ts.timesheet_id,ts.spend_time_hrs,trunc(ts.timesheet_for_date),s.status,s.approved_by,trunc(s.status_update_date) from (user_details u inner join task_details td on u.user_id=td.user_id inner join timesheets ts on td.task_id=ts.task_id  inner join status s on ts.timesheet_id=s.timesheet_id) where ts.timesheet_for_date='"+timesheetdate+"' and u.user_name='"+username+"'";
		Connectionutil conutil=new Connectionutil();
		Connection con=conutil.getDbConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{
			pstmt=con.prepareStatement(query);	
			rs=pstmt.executeQuery();
		while(rs.next())
		{
//			System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)+
//				 rs.getInt(4)+rs.getInt(5)+rs.getDate(6)+rs.getString(7)+rs.getString(8)+rs.getDate(9));
		Report report=new Report(rs.getString(1),rs.getString(2),rs.getString(3),
				 rs.getInt(4),rs.getInt(5),rs.getDate(6),rs.getString(7),rs.getString(8),rs.getDate(9));
		 reportlist.add(report);	
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("somthing went wrong");
		}
		return reportlist;
		
	}

}
