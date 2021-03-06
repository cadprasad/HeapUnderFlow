package com.learning.cmad.blog.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.learning.cmad.blog.api.Blog;
import com.learning.cmad.user.api.User;

public class JPABlogDAO implements BlogDAO {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_db");
	private EntityManager em = emf.createEntityManager();
	
	
	@Override
	public void createBlog(Blog blog) {
		em.getTransaction().begin();
		em.persist(blog);
		em.getTransaction().commit();
		em.close();		
	}

	@Override
	public List<Blog> getAllBlogs() {
		Query query = em.createQuery("from Blog");
		List<Blog> blogs = query.getResultList();
		return blogs;
	}

	@Override
	public Blog getBlogById(String id) {
		Query query = em.createQuery("from Blog where blogId = :id").setParameter("id", id);
		Blog blog = (Blog) query.getSingleResult();
		return blog;
	}

	
	@Override
	public void updateBlog(Blog blog) {
		em.getTransaction().begin();
		em.merge(blog);	//merging the object
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void deleteBlog(Blog blog) {
		deleteBlogById(blog.getBlogId());
		
	}

	@Override
	public void deleteBlogById(String id) {
		em.getTransaction().begin();
		em.remove(em.find(Blog.class, id));
		em.getTransaction().commit();
		em.close();
		
	}


	@Override
	public List<Blog> searchBlog(String q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> getAllBlogsPagination(int limit, int start) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
