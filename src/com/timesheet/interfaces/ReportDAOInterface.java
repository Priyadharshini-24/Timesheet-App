package com.timesheet.interfaces;

import java.util.List;

import com.timesheet.module.Report;

public interface ReportDAOInterface {
	public List<Report> findreport(String timesheetdate,String username);

}
