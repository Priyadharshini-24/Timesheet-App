package com.timesheet.interfaces;

import com.timesheet.module.User;

public interface AdminDAOInterface {
	public User validateAdmin(String username,String password);
}
