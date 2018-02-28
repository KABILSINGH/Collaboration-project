package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.BlogPost;
@Repository
@Transactional
public class BlogPostDaoImpl implements BlogPostDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void addBlogPost(BlogPost blogPost) {
		
         Session session=sessionFactory.getCurrentSession();
         session.save(blogPost);
	}
	@Override
	public List<BlogPost> listofBlogs(int approved) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from BlogPost where approved=" +approved);
		List<BlogPost> blogs=query.list();
		return blogs;
	}

}
