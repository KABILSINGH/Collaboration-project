package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Friend;
import com.model.User;
@Repository
@Transactional
public class FriendDaoImpl implements FriendDao {
@Autowired
private SessionFactory sessionFactory;
	@Override
	public List<User> suggestedUsers(String email) {
		Session session=sessionFactory.getCurrentSession();
	String queryString="select * from user_180250 where email in"
			+ "(select email from user_180250 where email!=?"
			+"minus "
			+"(select toId_email from friend_s180250 where fromId_email=?"
			+"union "
			+"select fromId_email from friend_s180250 where toId_email=?))";
	SQLQuery query=session.createSQLQuery(queryString);
	query.setString(0, email);
	query.setString(1, email);
	query.setString(2, email);
	query.addEntity(User.class);
	List<User> suggestedUsers=query.list();
		return suggestedUsers;
	}
	@Override
	public void addFriend(Friend friend) {
		Session session=sessionFactory.getCurrentSession();
		session.save(friend);
		
	}
	@Override
	public List<Friend> pendingRequests(String toIdEmail) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Friend where status=? and toId.email=?");
		query.setCharacter(0, 'P');
		query.setString(1, toIdEmail);
		List<Friend>pendingRequests=query.list();
		return pendingRequests;
	}

}
