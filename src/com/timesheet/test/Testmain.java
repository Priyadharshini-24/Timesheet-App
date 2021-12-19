package com.timesheet.test;

import java.util.List;
import java.util.Scanner;
import com.timesheet.dao.AdminDAO;
import com.timesheet.dao.StatusDAO;
import com.timesheet.dao.TaskDAO;
import com.timesheet.dao.TimesheetDAO;
import com.timesheet.dao.UserDAO;
import com.timesheet.module.Status;
import com.timesheet.module.Task;
import com.timesheet.module.Timesheet;
import com.timesheet.module.User;

public class Testmain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Timesheet App");
		System.out.println("\n1.Register\n2.Login\nEnter ur choice");
		int choice = Integer.parseInt(sc.nextLine());
		UserDAO userdao = null;
		AdminDAO admindao = null;
		TaskDAO taskdao =null;
		TimesheetDAO timesheetdao=null;
		StatusDAO statusdao=null;
		switch (choice) {
		case 1:
			String firstname = null;
			String lastname = null;
			String username = null;
			String password = null;
			String confirmpassword = null;
			userdao = new UserDAO();
			int flag = 0;
			do {
				System.out.println("Enter first name:");
				firstname = sc.nextLine();
				if (firstname.matches("[A-Za-z]{3,}")) {
					flag = 0;
					break;
				} else {
					System.out.println("invalid first name");
					flag = 1;
				}
			} while (flag == 1);

			do {
				System.out.println("Enter last name:");
				lastname = sc.nextLine();
				if (lastname.matches("[A-Za-z]{3,}")) {
					flag = 0;
					break;
				} else {
					System.out.println("invalid last name");
					flag = 1;
				}
			} while (flag == 1);

			do {
				System.out.println("Enter User Name:");
				username = sc.nextLine();
				if (username.matches("[a-z0-9.]+[@][a-z]+[.][]a-z]+")) {
					flag = 0;
					break;
				} else {
					System.out.println("invalid username");
					flag = 1;
				}
			} while (flag == 1);

			do {
				System.out.println("Enter Password:");
				password = sc.nextLine();
				if (password.matches("[A-Z]+[a-z]+[0-9]+[@#.]+{8,10}")) {
					flag = 0;
					break;
				} else {
					System.out.println("invalid password");
					flag = 1;
				}
			} while (flag == 1);

			do {
				System.out.println("Enter Confirm Password:");
				confirmpassword = sc.nextLine();
				if (password.equals(confirmpassword)) {
					flag = 0;
					break;
				} else {
					System.out.println("pls enter confirm password same as password");
					flag = 1;
				}
			} while (flag == 1);

			User user = new User(firstname, lastname, username, password);
			userdao.insertUser(user);
		case 2:
			System.out.println("do u want to Login...(y/n)");
			char ch = sc.nextLine().charAt(0);
			switch (ch) {
			case 'y':
				userdao = new UserDAO();
				admindao = new AdminDAO();
				System.out.println("User Login");
				System.out.println("Enter registered User Name:");
				username = sc.nextLine();
				do {
					if (username.matches("[a-z0-9.]+[@][a-z]+[.][]a-z]+")) {
						flag = 0;
						break;
					} else {
						System.out.println("Mismatch username");
						System.out.println("Enter valid User Name:");
						username = sc.nextLine();
						flag = 1;
					}
				} while (flag == 1);
				do {
					System.out.println("Enter valid Password:");
					password = sc.nextLine();
					if (password.matches("[A-Z]+[a-z]+[0-9]+[@#.]+{8,10}")) {
						flag = 0;
						break;
					} else {
						System.out.println("Miamatch password");
						System.out.println("Enter valid Password:");
						password = sc.nextLine();
						flag = 1;
					}
				} while (flag == 1);
				User validUser = userdao.validateUser(username, password);
				//admin
				if (validUser == null) {
					User adminuser = admindao.validateAdmin(username, password);
					System.out.println("Welcome\t" + adminuser.getFirstname() + " as Admin");
					System.out.println("1.view user\n2.Remove user\n3.Find UserId\n4.Add Task\n5.Edit Task\n6.View Task\n7.Remove task\n8.View Timesheet\n9.Find TimesheetId\n10.Enter Status\n11.update status\n12.view status");
					int urchoice = Integer.parseInt(sc.nextLine());
					switch (urchoice) {
					case 1:
						userdao = new UserDAO();
						List<User> showUser = userdao.showalluser();
						for (int i = 0; i < showUser.size(); i++) 
						{
							System.out.println(showUser.get(i));
						}
						break;
					case 2:
						userdao = new UserDAO();
						System.out.println("Enter User name to remove : ");
						username=sc.nextLine();
						userdao.removeUser(username);
						break;
					case 3:
						userdao=new UserDAO();
						System.out.println("Enter User name: ");
						username=sc.nextLine();
						int id=UserDAO.findUserId(username);
						System.out.println("User Id : "+id);
						break;
					case 4:
						int userid=0;
						String task=null;
						String dateassigned=null;;
						String enddate=null;
						String taskpriority=null;
						String assignedto=null;
						taskdao=new TaskDAO();
						System.out.println("Enter User Id:");
						userid=Integer.parseInt(sc.nextLine());
						System.out.println("Enter Task Name:");
						task=sc.nextLine();
						System.out.println("Enter Date to Assign Task : ");
						dateassigned=sc.nextLine();
						System.out.println("Enter End Date : ");
						enddate=sc.nextLine();
						System.out.println("Enter Task Priority : ");
						taskpriority=sc.nextLine();
						System.out.println("Enter User Name to task Assign : ");
						assignedto=sc.nextLine();
						Task taskobj=new Task(userid,task,dateassigned,enddate,taskpriority,assignedto);
						taskdao.insertTask(taskobj);
						break;
					case 5:
						taskdao=new TaskDAO();
						System.out.println("Enter Date to update Task : ");
						dateassigned=sc.nextLine();
						System.out.println("Enter User Id u want to update:");
						userid=Integer.parseInt(sc.nextLine());
						System.out.println("Enter Task Name u want to update:");
						task=sc.nextLine();
						System.out.println("Enter End Date u want to update : ");
						enddate=sc.nextLine();
						System.out.println("Enter Task Priority u want to update : ");
						taskpriority=sc.nextLine();
						System.out.println("Enter User Name to task Assign u want to update : ");
						assignedto=sc.nextLine();
					  taskobj=new Task(userid,task,dateassigned,enddate,taskpriority,assignedto);
					  taskdao.updateTask(taskobj);
					  break;
					case 6:
						taskdao = new TaskDAO();
						List<Task> showTask = taskdao.showallTask();
						for (int i = 0; i < showTask.size(); i++) 
						{
							System.out.println(showTask.get(i));
						}
						break;
					case 7:
						taskdao = new TaskDAO();
						System.out.println("Enter Task name to remove : ");
						task=sc.nextLine();
						taskdao.removeTask(task);
						break;
					case 8:
						timesheetdao=new TimesheetDAO();
						List<Timesheet> showTimesheet=timesheetdao.showTimesheet();
						for(int i=0;i<showTimesheet.size();i++)
						{
							System.out.println(showTimesheet.get(i));
						}
						break;
					case 9:
						String timesheetfordate=null;
						timesheetdao=new TimesheetDAO();
						System.out.println("Enter Timesheet for Date : ");
						timesheetfordate=sc.nextLine();
					    id=TimesheetDAO.findTimesheetId(timesheetfordate);
						System.out.println("Timesheet Id : "+id);
						break;
					case 10:
						userid=0;
						int timesheetid=0;
						String status=null;
						String approvedby=null;
						statusdao=new StatusDAO();
						System.out.println("Enter User Id :");
						userid=Integer.parseInt(sc.nextLine());
						System.out.println("Enter Timesheet Id : ");
						timesheetid=Integer.parseInt(sc.nextLine());
						System.out.println("Enter status : ");
						status=sc.nextLine();
						System.out.println("Enter Approved by:");
						approvedby=sc.nextLine();
						Status statusobj=new Status(userid,timesheetid,status,approvedby);
						statusdao.insertStatus(statusobj);
						break;
					}
				}

				else {
					System.out.println("Welcome\t" + validUser.getFirstname());

					System.out.println(" 1.Edit Profile\n 2.View Task\n3.Find Task Id\n4.Enter Timesheet\n5.Edit Timesheet\n6.Remove Timesheet\n7.View Timesheet\nEnter ur choice");
					int urchoice = Integer.parseInt(sc.nextLine());
					switch (urchoice) {
					case 1:
						userdao = new UserDAO();
						do {
							System.out.println("Enter first name u want to change :");
							firstname = sc.nextLine();
							if (firstname.matches("[A-Za-z]{3,}")) {
								flag = 0;
								break;
							} else {
								System.out.println("Enter valid first name");
								flag = 1;
							}
						} while (flag == 1);

						do {
							System.out.println("Enter last name u want to change :");
							lastname = sc.nextLine();
							if (lastname.matches("[A-Za-z]{3,}")) {
								flag = 0;
								break;
							} else {
								System.out.println("Enter valid last name");
								flag = 1;
							}
						} while (flag == 1);

						do {
							System.out.println("Enter User Name for where to update :");
							username = sc.nextLine();
							if (username.matches("[a-z0-9.]+[@][a-z]+[.][]a-z]+")) {
								flag = 0;
								break;
							} else {
								System.out.println("Enter valid username");
								flag = 1;
							}
						} while (flag == 1);

						do {
							System.out.println("Enter new Password:");
							password = sc.nextLine();
							if (password.matches("[A-Z]+[a-z]+[0-9]+[@#.]+{8,10}")) {
								flag = 0;
								break;
							} else {
								System.out.println("Enter valid password");
								flag = 1;
							}
						} while (flag == 1);

						do {
							System.out.println("Enter Confirm Password:");
							confirmpassword = sc.nextLine();
							if (password.equals(confirmpassword)) {
								flag = 0;
								break;
							} else {
								System.out.println("pls enter confirm password same as password");
								flag = 1;
							}
						} while (flag == 1);

						user = new User(firstname, lastname, username, password);
						userdao.updateUser(user);
						break;
					case 2:
						taskdao = new TaskDAO();
						List<Task> showTask = taskdao.showallTask();
						for (int i = 0; i < showTask.size(); i++) 
						{
							System.out.println(showTask.get(i));
						}
						break;
					case 3:
						String task=null;
						taskdao=new TaskDAO();
						System.out.println("Enter Task name: ");
						task=sc.nextLine();
						int id=TaskDAO.findtaskId(task);
						System.out.println("Task Id : "+id);
						break;
					case 4:
						int userid=0;
						int taskid=0;
						int spendtime=0;
						String comments=null,timesheetfordate=null;
						timesheetdao=new TimesheetDAO();
						System.out.println("Enter User Id :");
						userid=Integer.parseInt(sc.nextLine());
						System.out.println("Enter Task Id :");
						taskid=Integer.parseInt(sc.nextLine());
						System.out.println("Enter Spending time in hrs :");
						spendtime=Integer.parseInt(sc.nextLine());
						System.out.println("Enter Comments:");
						comments=sc.nextLine();
						System.out.println("Enter timesheet for Date :");
						timesheetfordate=sc.nextLine();
						Timesheet timesheet=new Timesheet(userid,taskid,spendtime,comments,timesheetfordate);
						timesheetdao.insertTimesheet(timesheet);
						break;
					case 5:
						timesheetdao=new TimesheetDAO();
						System.out.println("Enter User Id to update:");
						userid=Integer.parseInt(sc.nextLine());
						System.out.println("Enter Task Id to update :");
						taskid=Integer.parseInt(sc.nextLine());
						System.out.println("Enter Spending time in hrs to update :");
						spendtime=Integer.parseInt(sc.nextLine());
						System.out.println("Enter Comments to update:");
						comments=sc.nextLine();
						System.out.println("Enter timesheet Date where to update :");
						timesheetfordate=sc.nextLine();
						 timesheet=new Timesheet(userid,taskid,spendtime,comments,timesheetfordate);
						 timesheetdao.updateTimesheet(timesheet);
						 break;
					case 6:
						timesheetdao = new TimesheetDAO();
						System.out.println("Enter Timesheet date to remove : ");
						timesheetfordate=sc.nextLine();
						timesheetdao.removeTimesheet(timesheetfordate);
						break;
					case 7:
						timesheetdao=new TimesheetDAO();
						List<Timesheet> showTimesheet=timesheetdao.showTimesheet();
						for(int i=0;i<showTimesheet.size();i++)
						{
							System.out.println(showTimesheet.get(i));
						}
						break;
					}
				}
			case 'n':
				System.exit(0);
			}
		}
	}

}
