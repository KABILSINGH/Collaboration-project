package com.collaborationApp.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborationApp.dao.ProfilePictureDao;
import com.collaborationApp.model.ProfilePicture;
/**
 * 
 * @author kabilsingh.balan
 *
 */
@Repository
@Transactional
public class ProfilePictureDaoImpl implements ProfilePictureDao{
	   @Autowired
	private SessionFactory sessionFactory;
	   public void uploadProfilePicture(ProfilePicture profilePicture) {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(profilePicture);
	   }
	
	public ProfilePicture getProfilePic(String email) {
		Session session=sessionFactory.getCurrentSession();
		ProfilePicture profilePicture=(ProfilePicture)session.get(ProfilePicture.class, email);
		System.out.println("DAO " + email + " " + profilePicture);
		return profilePicture;
	}

	
	
		

	}

