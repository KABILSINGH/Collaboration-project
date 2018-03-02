package com.dao;

import java.util.List;

import com.model.BlogPost;

public interface BlogPostDao {
void addBlogPost(BlogPost blogPost);
List<BlogPost>listofBlogs(int approved);
BlogPost getBlog(int id);
}
