package com.example.demo.dtos;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;

import com.example.demo.model.Post;

public class UserPostCommentsDto 
{

	//@Column(name = "fname")
	String firstName; 
///	@Column(name = "lname")
//	String lastName; 
	List<String> title;
	
	/////@Column(name = "comments")
	List<String> comments;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public List<String> getTitle() {
		return title;
	}
	public void setTitle(List<String> title) {
		this.title = title;
	}
	public List<String> getComments() {
		return comments;
	}
	public void setComments(List<String> comments) {
		this.comments = comments;
	}
	public UserPostCommentsDto(String firstName, List<String> title, List<String> comments) {
		super();
		this.firstName = firstName;
		this.title = title;
		this.comments = comments;
	}
	
	
	
	
}
