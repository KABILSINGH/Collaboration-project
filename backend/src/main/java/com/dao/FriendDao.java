package com.dao;

import java.util.List;

import com.model.User;

public interface FriendDao {
List<User>suggestedUsers(String email);
}
