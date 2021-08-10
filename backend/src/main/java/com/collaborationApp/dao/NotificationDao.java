package com.collaborationApp.dao;

import java.util.List;

import com.collaborationApp.model.Notification;
/**
 * 
 * @author kabilsingh.balan
 *
 */
public interface NotificationDao {
public List<Notification>getNotificationsNotViewed(String email);

public Notification getNotification(int id);

public void updateNotification(int id);
}
