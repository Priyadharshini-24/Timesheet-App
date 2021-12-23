package com.timesheet.module;

public class Rejecttimesheet {
	private int timesheetid;
	private int taskid;
	private String timesheetdate;
	private int spendtimehrs;
	private String status;
	public int getTimesheetid() {
		return timesheetid;
	}
	public void setTimesheetid(int timesheetid) {
		this.timesheetid = timesheetid;
	}
	public int getTaskid() {
		return taskid;
	}
	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	public String getTimesheetdate() {
		return timesheetdate;
	}
	public void setTimesheetdate(String timesheetdate) {
		this.timesheetdate = timesheetdate;
	}
	public int getSpendtimehrs() {
		return spendtimehrs;
	}
	public void setSpendtimehrs(int spendtimehrs) {
		this.spendtimehrs = spendtimehrs;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Rejecttimesheet(int timesheetid, int taskid, String timesheetdate, int spendtimehrs, String status) {
		super();
		this.timesheetid = timesheetid;
		this.taskid = taskid;
		this.timesheetdate = timesheetdate;
		this.spendtimehrs = spendtimehrs;
		this.status = status;
	}
	public Rejecttimesheet() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Rejected timesheet id = " + timesheetid + "\n task id = " + taskid + "\n timesheet date = " + timesheetdate
				+ "\nspend time hrs = " + spendtimehrs + "\nstatus = " + status + "\n";
	}
	
	

}
