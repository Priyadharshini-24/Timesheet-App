package com.timesheet.interfaces;

import java.util.List;

import com.timesheet.module.Task;

public interface TaskDAOInterface {
	public void insertTask(Task task);
	public void updateTask(Task task);
	public List<Task> showallTask();
	public  int findtaskId(String task);
	public void removeTask(String task);

}
