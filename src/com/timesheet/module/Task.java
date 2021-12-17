package com.timesheet.module;

public class Task {
	private int userid;
	private String task;
	private String startdate;
	private String enddate;
	private String taskpriority;
	private String assignedto;
	private String dateassigned;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getTask_priority() {
		return taskpriority;
	}
	public void setTask_priority(String task_priority) {
		this.taskpriority = task_priority;
	}
	public String getAssigned_to() {
		return assignedto;
	}
	public void setAssigned_to(String assigned_to) {
		this.assignedto = assigned_to;
	}
	public String getDate_assigned() {
		return dateassigned;
	}
	public void setDate_assigned(String date_assigned) {
		this.dateassigned = date_assigned;
	}
	public Task(int userid,String task, String startdate, String enddate, String task_priority, String assigned_to,
			String date_assigned) {
		super();
		this.userid=userid;
		this.task = task;
		this.startdate = startdate;
		this.enddate = enddate;
		this.taskpriority = task_priority;
		this.assignedto = assigned_to;
		this.dateassigned = date_assigned;
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Task [userid=" + userid + ", task=" + task + ", startdate=" + startdate + ", enddate=" + enddate
				+ ", task_priority=" + taskpriority + ", assigned_to=" + assignedto + ", date_assigned="
				+ dateassigned + "]";
	}
	

}
