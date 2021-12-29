package com.timesheet.interfaces;

import java.util.List;

import com.timesheet.module.Timesheet;

public interface TimesheetDAOInterface {
	public void insertTimesheet(Timesheet timesheet);
	public void updateTimesheet(Timesheet timesheet);
	public List<Timesheet> showTimesheet();
	public void removeTimesheet(String timesheetfordate);
	public  int findTimesheetId(String timesheetfordate);
}
