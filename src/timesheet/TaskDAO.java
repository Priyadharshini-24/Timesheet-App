package timesheet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskDAO {
	public void insertTask(Task task)
	{
		String insertquery="INSERT INTO USER_DETAIL(TASK_NAME,START_DATE,END_DATE,TASK_PRIORITY,ASSIGNED_TO,ASSIGNED_DATE)VALUES(?,?,?,?,?,?)";
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
	public void updateTask(Task task)
	{
		
		
	}
}
