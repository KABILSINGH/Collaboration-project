package com.collaborationApp.dao;

import com.collaborationApp.model.BlogPost;
import com.collaborationApp.model.BlogPostLikes;
/**
 * 
 * @author kabilsingh.balan
 *
 */
public interface BlogPostLikesDao {
	public BlogPostLikes hasUserLikedBlog(int blogId,String email);
	public BlogPost updateLikes(int id,String email);

}
