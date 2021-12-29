package com.timesheet.interfaces;

import java.util.List;

import com.timesheet.module.User;

public interface UserDAOInterface {
	public void insertUser(User user);
	public User validateUser(String username,String password);
	public void updateUser(User user);
	public List<User> showalluser();
	public void removeUser(String username);
	public int findUserId(String username);
}
