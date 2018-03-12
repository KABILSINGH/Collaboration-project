package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.BlogComment;
import com.model.BlogPost;
import com.model.Notification;
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
	@Override
	public BlogPost getBlog(int id) {
		Session session=sessionFactory.getCurrentSession();
		BlogPost blogPost=(BlogPost)session.get(BlogPost.class, id);
		return blogPost;
	}
	@Override
	public void approve(BlogPost blog) {
		Session session=sessionFactory.getCurrentSession();
		blog.setApproved(true);
		session.update(blog);
		Notification notification=new Notification();
		notification.setBlogTitle(blog.getBlogTitle());
		notification.setApprovalStatus("Approved");
		notification.setEmail(blog.getPostedBy().getEmail());
		session.save(notification);
		
	}
	@Override
	public void reject(BlogPost blog,String rejectionReason) {
		Session session=sessionFactory.getCurrentSession();
		Notification notification=new Notification();
		notification.setBlogTitle(blog.getBlogTitle());
		notification.setApprovalStatus("Rejected");
		notification.setEmail(blog.getPostedBy().getEmail());
		notification.setRejectionReason(rejectionReason);
		session.save(notification);
		session.delete(blog);
		
	}
	@Override
	public void addBlogComment(BlogComment blogComment) {
	Session session=sessionFactory.getCurrentSession();
	session.save(blogComment);
		
	}
	@Override
	public List<BlogComment> getAllBlogComments(int blogPostId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from BlogComment where blogPost.id=?");
		query.setInteger(0, blogPostId);
		List<BlogComment> blogComments=query.list();
		return blogComments;
	}
}
