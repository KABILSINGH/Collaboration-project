package com.collaborationApp.dao;

import com.collaborationApp.model.ProfilePicture;
/**
 * 
 * @author kabilsingh.balan
 *
 */
public interface ProfilePictureDao {
	
	ProfilePicture getProfilePic(String email);
	void uploadProfilePicture(ProfilePicture profilePicture);
	}

