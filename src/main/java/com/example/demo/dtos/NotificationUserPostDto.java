package com.example.demo.dtos;

public class NotificationUserPostDto
{

	String nameUser;
	String nameComments; 
	
	
	
	public NotificationUserPostDto(String nameUser, String nameComments) {
		super();
		this.nameUser = nameUser;
		this.nameComments = nameComments;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public String getNameComments() {
		return nameComments;
	}
	public void setNameComments(String nameComments) {
		this.nameComments = nameComments;
	}
	
	
	
	
	
}
