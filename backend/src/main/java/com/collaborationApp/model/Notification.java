package com.collaborationApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author kabilsingh.balan
 *
 */
@Entity
@Table(name="NOTIFICATION")
public class Notification {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String blogTitle;
private String email;
private String approvalStatus;
private String rejectionReason;
private boolean viewed;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBlogTitle() {
	return blogTitle;
}
public void setBlogTitle(String blogTitle) {
	this.blogTitle = blogTitle;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getApprovalStatus() {
	return approvalStatus;
}
public void setApprovalStatus(String approvalStatus) {
	this.approvalStatus = approvalStatus;
}
public String getRejectionReason() {
	return rejectionReason;
}
public void setRejectionReason(String rejectionReason) {
	this.rejectionReason = rejectionReason;
}
public boolean isViewed() {
	return viewed;
}
public void setViewed(boolean viewed) {
	this.viewed = viewed;
}

}
