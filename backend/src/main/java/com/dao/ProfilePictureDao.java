package com.dao;

import com.model.ProfilePicture;

public interface ProfilePictureDao {
	
	ProfilePicture getProfilePic(String email);
	void uploadProfilePicture(ProfilePicture profilePicture);
	}

