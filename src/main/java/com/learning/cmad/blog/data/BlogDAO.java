package com.learning.cmad.blog.data;

import java.util.List;

import com.learning.cmad.blog.api.Blog;

public interface BlogDAO {


	//Create
	public void createBlog(Blog blog);
	
	//Read
	public List<Blog> getAllBlogs();
	public Blog getBlogById(String id);
	
	//Update
	public void updateBlog(Blog blog);
	
	
	//Delete
	public void deleteBlog(Blog blog);
	public void deleteBlogById(String id);
	
	//Search
	public List<Blog> searchBlog(String q);
}
