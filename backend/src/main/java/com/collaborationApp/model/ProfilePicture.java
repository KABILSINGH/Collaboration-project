package com.collaborationApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
/**
 * 
 * @author kabilsingh.balan
 *
 */
@Entity
@Table(name="PROFILE_PICTURE")
public class ProfilePicture {
	@Id
	private String email;
	@Lob
	private byte[] image;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	

}
