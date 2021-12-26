package com.timesheet.module;

import java.util.Date;

public class Rejecttimesheet {
	private String task;
	private int timesheetid;
	private Date timesheetdate;
	private int spendtimehrs;
	private String comments;
	private String approvedby;
	private String status;
	
	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public int getTimesheetid() {
		return timesheetid;
	}

	public void setTimesheetid(int timesheetid) {
		this.timesheetid = timesheetid;
	}

	public Date getTimesheetdate() {
		return timesheetdate;
	}

	public void setTimesheetdate(Date timesheetdate) {
		this.timesheetdate = timesheetdate;
	}

	public int getSpendtimehrs() {
		return spendtimehrs;
	}

	public void setSpendtimehrs(int spendtimehrs) {
		this.spendtimehrs = spendtimehrs;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getApprovedby() {
		return approvedby;
	}

	public void setApprovedby(String approvedby) {
		this.approvedby = approvedby;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public Rejecttimesheet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rejecttimesheet(String task, int timesheetid, Date timesheetdate, int spendtimehrs, String comments,
			String approvedby, String status) {
		super();
		this.task = task;
		this.timesheetid = timesheetid;
		this.timesheetdate = timesheetdate;
		this.spendtimehrs = spendtimehrs;
		this.comments = comments;
		this.approvedby = approvedby;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Rejected Timesheet \n task Name : " + task + "\n Timesheet Id : " + timesheetid + "\n Timesheet Date=" + timesheetdate
				+ "\n spend Time HRS : " + spendtimehrs + "\n Comments :" + comments + "\n Approved by : " + approvedby
				+ "\n Status : " + status + "\n";
	}
	
}
