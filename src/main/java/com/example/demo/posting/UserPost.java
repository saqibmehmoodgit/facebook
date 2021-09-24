package com.example.demo.posting;

import java.sql.Timestamp;

import javax.persistence.Column;

public class UserPost 
{
	private String title;
	private String description;
	
	
	private String image;
	private int whoCreated;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getWhoCreated() {
		return whoCreated;
	}
	public void setWhoCreated(int whoCreated) {
		this.whoCreated = whoCreated;
	}
	
	
	
	
}
