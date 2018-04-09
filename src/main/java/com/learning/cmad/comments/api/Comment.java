package com.learning.cmad.comments.api;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Comment {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private String commentId;
	private String comment;
	private int blogId;
	private int userId;
	
	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Comment(){
		
	}
	
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String string) {
		this.commentId = string;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
