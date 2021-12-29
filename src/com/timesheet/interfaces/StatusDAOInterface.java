package com.timesheet.interfaces;

import java.util.List;

import com.timesheet.module.Status;

public interface StatusDAOInterface {
	public void insertStatus(Status status);
	public void updateStatus(Status status);
	 public List<Status> showStatus();
	 public void removeStatus(int timesheetid);

}
