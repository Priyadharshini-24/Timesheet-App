package com.timesheet.module;

import java.util.Objects;

public class Timesheet {
	private int userid;
	private int taskid;
	private int spendtime;
	private String comments;
	private String timesheetfordate;
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
	public int getSpendtime() {
		return spendtime;
	}
	public void setSpendtime(int spendtime) {
		this.spendtime = spendtime;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getTimesheetfordate() {
		return timesheetfordate;
	}
	public void setTimesheetfordate(String timesheetfordate) {
		this.timesheetfordate = timesheetfordate;
	}
	public Timesheet() {
		super();
	}
	public Timesheet(int userid, int taskid, int spendtime, String comments, String timesheetfordate)
	{
		super();
		this.userid = userid;
		this.taskid = taskid;
		this.spendtime = spendtime;
		this.comments = comments;
		this.timesheetfordate = timesheetfordate;
	}
	@Override
	public String toString() {
		return "User Id : " + userid + "\nTask Id : " + taskid + "\nSpend Time in Hrs : " + spendtime + "\nComments : "
				+ comments + "\nTimesheet for date : " + timesheetfordate+"\n";
	}
	@Override
	public int hashCode() {
		return Objects.hash(comments, spendtime, taskid, timesheetfordate, userid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Timesheet other = (Timesheet) obj;
		return Objects.equals(comments, other.comments) && spendtime == other.spendtime && taskid == other.taskid
				&& Objects.equals(timesheetfordate, other.timesheetfordate) && userid == other.userid;
	}
	
	
}
