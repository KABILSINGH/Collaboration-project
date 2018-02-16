package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dao.UserDao;
import com.model.ErrorClazz;
import com.model.User;

@RestController
public class UserController {
	@Autowired
private UserDao userDao;
	public UserController()
	{
		System.out.println("UserController is Created");
	}
	@RequestMapping(value="/registeruser",method=RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody User user){
		System.out.println("registeruser in usercontroller" +user);
		if(!userDao.isEmailUnique(user.getEmail()))
		{
			ErrorClazz error= new ErrorClazz(1,"Email already exist");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.CONFLICT);
		}
		try {
			userDao.registerUser(user);
			}
			catch(Exception e) {
				ErrorClazz error =new ErrorClazz(2,"Some required field are empty" +e.getMessage());
				return new ResponseEntity<ErrorClazz>(error, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity<?>login(@RequestBody User user){
		User ValidUser=userDao.login(user);
		if(ValidUser==null){
			ErrorClazz error=new ErrorClazz(5,"login failed invalid email id or password" );
			return new ResponseEntity<ErrorClazz>(error, HttpStatus.UNAUTHORIZED);
		}
		else
		{  ValidUser.setOnline(true);
		    userDao.update(ValidUser);
			return new ResponseEntity<User>(ValidUser,HttpStatus.OK);
		}
	}
	public ResponseEntity<?>logout(HttpSession session){
		String email=(String)session.getAttribute("loginId");
		if(email==null){
			ErrorClazz error=new ErrorClazz(4,"Please login..");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		User user=userDao.getUser(email);
		user.setOnline(false);
		userDao.update(user);
		session.removeAttribute("loginId");
		session.invalidate();
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
}

