package com.timesheet.module;

public class Timesheet {
	private int userid;
	private int taskid;
	private int spend_time;
	private String comments;
	private String timesheet_for_date;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getTaskid() {
		return taskid;
	}
	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	public int getSpend_time() {
		return spend_time;
	}
	public void setSpend_time(int spend_time) {
		this.spend_time = spend_time;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getTimesheet_for_date() {
		return timesheet_for_date;
	}
	public void setTimesheet_for_date(String timesheet_for_date) {
		this.timesheet_for_date = timesheet_for_date;
	}
	public Timesheet() {
		super();
	}
	public Timesheet(int userid, int taskid, int spend_time, String comments, String timesheet_for_date)
	{
		super();
		this.userid = userid;
		this.taskid = taskid;
		this.spend_time = spend_time;
		this.comments = comments;
		this.timesheet_for_date = timesheet_for_date;
	}
}
