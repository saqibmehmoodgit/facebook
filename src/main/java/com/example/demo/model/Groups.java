package com.example.demo.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "groups")
public class Groups 
{
	@Id 
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name = "groupid")
	Long  groupId;
	@Column(name = "titile")
	String title;
	@Column(name = "created")
	Timestamp createdDate;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToMany(cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE
		} ,fetch=FetchType.LAZY)
		@JoinTable(name = "group_user",
		    joinColumns = @JoinColumn(name = "groupid"),
		    inverseJoinColumns = @JoinColumn(name = "userid")
		)
		private Set<Users> users = new HashSet<>();
	
	  public void addUser(Users user) {
	    	users.add(user);
	    	//user.getGroups().add(this);
	    	
	    }
	 
	    public void removeGroups(Users user) {
	    	users.remove(user);
	    	//user.getGroups().remove(this);
	    }
	
	
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public Set<Users> getUsers() {
		return users;
	}
	public void setUsers(Set<Users> users) {
		this.users = users;
	}
	
	
	
	
}
