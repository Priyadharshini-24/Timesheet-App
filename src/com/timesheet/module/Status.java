package com.timesheet.module;

import java.util.Objects;

public class Status {
	private int userid;
	private int timesheetid;
	private String status;
	private String approvedby;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getTimesheetid() {
		return timesheetid;
	}
	public void setTimesheetid(int timesheetid) {
		this.timesheetid = timesheetid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getApprovedby() {
		return approvedby;
	}
	public void setApprovedby(String approvedby) {
		this.approvedby = approvedby;
	}
	public Status() {
		super();
	}
	public Status(int userid, int timesheetid, String status, String approvedby) {
		super();
		this.userid = userid;
		this.timesheetid = timesheetid;
		this.status = status;
		this.approvedby = approvedby;
	}
	@Override
	public String toString() {
		return "User Id : " + userid + "\nTimesheet Id : " + timesheetid + "\nStatus : " + status + "\nApproved By : "
				+ approvedby + "\n";
	}
	@Override
	public int hashCode() {
		return Objects.hash(approvedby, status, timesheetid, userid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Status other = (Status) obj;
		return Objects.equals(approvedby, other.approvedby) && Objects.equals(status, other.status)
				&& timesheetid == other.timesheetid && userid == other.userid;
	}
	
	
}
