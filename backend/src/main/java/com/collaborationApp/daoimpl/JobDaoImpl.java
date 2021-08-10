package com.collaborationApp.daoimpl;

import java.util.*;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborationApp.dao.JobDao;
import com.collaborationApp.model.Job;
/**
 * 
 * @author kabilsingh.balan
 *
 */
@Repository
@Transactional
public class JobDaoImpl implements JobDao {
	@Autowired
private SessionFactory sessionFactory;
	public void addJob(Job job) {
		Session session=sessionFactory.getCurrentSession();
		session.save(job);

	}
	public List<Job> getAllJobs() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Job");
		return query.list();
	}
	public Job getJob(int id) {
		Session session=sessionFactory.getCurrentSession();
		Job job=(Job)session.get(Job.class, id);
		return job;
	}

}
