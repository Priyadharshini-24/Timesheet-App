package com.timesheet.test;

import java.util.List;
import java.util.Scanner;
import com.timesheet.dao.AdminDAO;
import com.timesheet.dao.UserDAO;
import com.timesheet.module.User;

public class Testmain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Timesheet App");
		System.out.println("\n1.Register\n2.Login\nEnter ur choice");
		int choice = Integer.parseInt(sc.nextLine());
		UserDAO userdao = null;
		AdminDAO admindao = null;
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
				if (validUser == null) {
					User adminuser = admindao.validateAdmin(username, password);
					System.out.println("Welcome\t" + adminuser.getFirstname() + " as Admin");
					System.out.println("1.view user");
					int urchoice = Integer.parseInt(sc.nextLine());
					switch (urchoice) {
					case 1:
						userdao = new UserDAO();
						List<User> showUser = userdao.showalluser();
						for (int i = 0; i < showUser.size(); i++) 
						{
							System.out.println(showUser.get(i));
						}
					case 2:
						userdao = new UserDAO();
						System.out.println("Enter User name to remove : ");
						username=sc.nextLine();
						userdao.removeUser(username);	
					}
				}

				else {
					System.out.println("Welcome\t" + validUser.getFirstname());

					System.out.println(" 1.Edit Profile\n 2.\nEnter ur choice");
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
					}
				}
			case 'n':
				System.exit(0);
			}
		}
	}

}
