package com.example.demo.dtos;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.example.demo.model.Comments;
import com.example.demo.model.Groups;
import com.example.demo.model.Institute;
import com.example.demo.model.Post;
import com.example.demo.model.Workplace;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//import lombok.Data;

///@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserPostDto 
{
	Long  userId;
	String firstName;
	String lastName;
	@JsonFormat(pattern="dd-MMM-yyyy HH:mm:ss")
	Timestamp birthDate;
	String bigPicture;
	String smallPicture;
	String picture;
	String religin;
	@JsonFormat(pattern="dd-MMM-yyyy HH:mm:ss")
	Timestamp updatTime;

	 private Set<Post> post = new HashSet<>();
//	 private Set<Comments> comments = new HashSet<>();
//	 private Set<Groups> groups = new HashSet<>();
//	 private Set<Workplace> workplace = new HashSet<>();
//	 private List<Institute> institute = new ArrayList<>();

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	public String getBigPicture() {
		return bigPicture;
	}

	public void setBigPicture(String bigPicture) {
		this.bigPicture = bigPicture;
	}

	public String getSmallPicture() {
		return smallPicture;
	}

	public void setSmallPicture(String smallPicture) {
		this.smallPicture = smallPicture;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getReligin() {
		return religin;
	}

	public void setReligin(String religin) {
		this.religin = religin;
	}

	public Timestamp getUpdatTime() {
		return updatTime;
	}

	public void setUpdatTime(Timestamp updatTime) {
		this.updatTime = updatTime;
	}

	public Set<Post> getPost() {
		return post;
	}

	public void setPost(Set<Post> post) {
		this.post = post;
	}

	 
	 
}
