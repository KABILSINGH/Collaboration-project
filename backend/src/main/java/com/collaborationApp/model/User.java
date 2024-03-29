package com.collaborationApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author kabilsingh.balan
 *
 */
@Entity
@Table(name="USER_DETAILS")
public class User {
	@Id
private String email;
	@Column(nullable=false)
private String password;
private String firstname;
private String lastname;
private String phonenumber;
private String role;
@Column(name="ONLINE_STATUS")
private boolean online;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
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
public String getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public boolean isOnline() {
	return online;
}
public void setOnline(boolean online) {
	this.online = online;
}
@Override
public String toString()
{
	return this.email + "" +this.firstname+ "" +this.phonenumber+""+this.role;
}
}
