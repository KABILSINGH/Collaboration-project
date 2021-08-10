package com.collaborationApp.dao;

import java.util.List;

import com.collaborationApp.model.Friend;
import com.collaborationApp.model.User;
/**
 * 
 * @author kabilsingh.balan
 *
 */
public interface FriendDao {
List<User>suggestedUsers(String email);
void addFriend(Friend friend);
List<Friend>pendingRequests(String toIdEmail);
void acceptRequest(Friend request);
void deleteRequest(Friend request);
List<Friend>listofFriends(String email);

}
