/**
 * 
 */
package com.apress.demo.entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Siva
 *
 */
public class Post
{
    private Integer id;
    private String title;
    private String content;
    private Timestamp createdOn;
    private List<Comment> comments = new ArrayList<>();
	
    public Post() {
	}
    
    public Post(Integer id, String title, String content, Timestamp createdOn) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdOn = createdOn;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
    public void addComment(Comment comment){
    	this.comments.add(comment);
    }
}

