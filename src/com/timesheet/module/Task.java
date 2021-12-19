package com.timesheet.module;
import java.util.Objects;
public class Task {
	private int userid;
	private String task;
	private String dateassigned;
	private String enddate;
	private String taskpriority;
	private String assignedto;
	
    
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

	public String getDateassigned() {
		return dateassigned;
	}

	public void setDateassigned(String dateassigned) {
		this.dateassigned = dateassigned;
	}
	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getTaskpriority() {
		return taskpriority;
	}

	public void setTaskpriority(String taskpriority) {
		this.taskpriority = taskpriority;
	}

	public String getAssignedto() {
		return assignedto;
	}

	public void setAssignedto(String assignedto) {
		this.assignedto = assignedto;
	}
	public Task() {
		super();
	}
	
	public Task(int userid, String task, String dateassigned, String enddate, String taskpriority, String assignedto) {
		super();
		this.userid = userid;
		this.task = task;
		this.dateassigned = dateassigned;
		this.enddate = enddate;
		this.taskpriority = taskpriority;
		this.assignedto = assignedto;
		
	}
	@Override
	public String toString() {
		return "UserId : " + userid + "\n Task Name : " + task +"\n Date assigned : " +dateassigned + "\n End date : " +enddate
				+ "\n Task Priority : " + taskpriority + "\n Assigned to : " + assignedto;
		}
	@Override
	public int hashCode() {
		return Objects.hash(assignedto,  enddate, dateassigned, task, taskpriority, userid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(assignedto, other.assignedto) && Objects.equals(enddate, other.enddate)
				&& Objects.equals(dateassigned, other.dateassigned)
				&& Objects.equals(task, other.task) && Objects.equals(taskpriority, other.taskpriority)
				&& userid == other.userid;
	}	
	
	}