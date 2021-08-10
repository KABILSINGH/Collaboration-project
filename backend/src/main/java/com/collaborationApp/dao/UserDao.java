package com.collaborationApp.dao;

import com.collaborationApp.model.User;

/**
 * 
 * @author kabilsingh.balan
 *
 */
public interface UserDao {
void registerUser(User user);
boolean isEmailUnique(String email);
User login(User user);
void update(User validUser);
User getUser(String email);
Void updateUser(User user);
/*List<User>searchUser(String name);*/
}
