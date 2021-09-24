package com.example.demo.posting;

import org.springframework.stereotype.Service;

public class UserMakesPostComments 
{

	private int postid;
	private int wholikes;
	private String comments;
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public int getWholikes() {
		return wholikes;
	}
	public void setWholikes(int wholikes) {
		this.wholikes = wholikes;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
	
}
