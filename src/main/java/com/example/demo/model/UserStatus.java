package com.example.demo.model;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "userstatus")
public class UserStatus 
{

	@Id
	@GeneratedValue
	Long staid;
	int status;
	@Column(name = "updatetime")
	Timestamp upDateTime;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "uid")
    private Users user;


	public Long getStaid() {
		return staid;
	}


	public void setStaid(Long staid) {
		this.staid = staid;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public Timestamp getUpDateTime() {
		return upDateTime;
	}


	public void setUpDateTime(Timestamp upDateTime) {
		this.upDateTime = upDateTime;
	}


	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}
	
	

}