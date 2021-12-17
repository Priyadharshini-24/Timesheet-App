package timesheet;

public class Task {
	private String task;
	private String startdate;
	private String enddate;
	private String task_priority;
	private String assigned_to;
	private String date_assigned;
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
		return task_priority;
	}
	public void setTask_priority(String task_priority) {
		this.task_priority = task_priority;
	}
	public String getAssigned_to() {
		return assigned_to;
	}
	public void setAssigned_to(String assigned_to) {
		this.assigned_to = assigned_to;
	}
	public String getDate_assigned() {
		return date_assigned;
	}
	public void setDate_assigned(String date_assigned) {
		this.date_assigned = date_assigned;
	}
	public Task(String task, String startdate, String enddate, String task_priority, String assigned_to,
			String date_assigned) {
		super();
		this.task = task;
		this.startdate = startdate;
		this.enddate = enddate;
		this.task_priority = task_priority;
		this.assigned_to = assigned_to;
		this.date_assigned = date_assigned;
	}
	@Override
	public String toString() {
		return "Task [task=" + task + ", startdate=" + startdate + ", enddate=" + enddate + ", task_priority="
				+ task_priority + ", assigned_to=" + assigned_to + ", date_assigned=" + date_assigned + "]";
	}

}
