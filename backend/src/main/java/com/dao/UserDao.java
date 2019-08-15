package com.dao;

import java.util.List;

import com.model.User;

public interface UserDao {
void registerUser(User user);
boolean isEmailUnique(String email);
User login(User user);
void update(User validUser);
User getUser(String email);
Void updateUser(User user);
/*List<User>searchUser(String name);*/
}
