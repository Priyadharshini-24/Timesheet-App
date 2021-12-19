package com.timesheet.module;

import java.util.Objects;

public class User 
{
private String firstname;
private String lastname;
private String username;
private String password;
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(String firstname, String lastname, String username, String password) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.username = username;
	this.password = password;
}
@Override
public String toString() {
	return "User firstname: " + firstname + "\n lastname: " + lastname + "\n username: " + username + "\n password: "
			+ password;
}
@Override
public int hashCode() {
	return Objects.hash(firstname, lastname, password, username);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return Objects.equals(firstname, other.firstname) && Objects.equals(lastname, other.lastname)
			&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
}

}
