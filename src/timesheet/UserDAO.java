package timesheet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	public void insertUser(User user)
	{
		String insertquery="INSERT INTO USER_DETAIL(FIRST_NAME,LAST_NAME,USER_NAME,PASSWORD)VALUES(?,?,?,?)";
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
			System.out.println("values not inserted");
		}
	}
	
	public User validateUser(String username,String password)
	{
		String validatequery="select * from USER_DETAIL where user_name='"+username+"'and password='"+password+"'";
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

	public List<User> showalluser()
	{
		List<User> userlist=new ArrayList<User>();
		String selectquery="select * from USER_DETAIL";
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
			User user=new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			userlist.add(user);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("values not selected");
		}
		
		return userlist;
		
	}
}
