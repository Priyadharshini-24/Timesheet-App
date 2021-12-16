package timesheet;

import java.util.Scanner;

public class Testmain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Timesheet App");
		System.out.println("\n1.Register\n2.Login\nEnter ur choice");
		int choice = Integer.parseInt(sc.nextLine());
		UserDAO userdao =null;
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
			userdao=new UserDAO();
			System.out.println("User Login");
			do {
				System.out.println("Enter registered User Name:");
				username=sc.nextLine();
				if (username.matches("[a-z0-9.]+[@][a-z]+[.][]a-z]+")) {
					flag = 0;
					break;
				} else {
					System.out.println("invalid username");
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
					System.out.println("invalid password");
					flag = 1;
				}
			} while (flag == 1);
			User validuser=userdao.validateUser(username, password);
			if(validuser!=null) {
				System.out.println("Welcome\t"+validuser.getFirstname());
			}
			break;
		}
	}

}
