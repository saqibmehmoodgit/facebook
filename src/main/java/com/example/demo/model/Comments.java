package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name = "comments")
public class Comments
{
	
	@Id 
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name = "commentsid")
	Long  commentsid;
	@Column(name = "comments")
	String comments;
	@Column(name = "child")
	boolean child;
	@JsonFormat(pattern="dd-MMM-yyyy HH:mm:ss")
	@Column(name = "created")
	Timestamp updatTime;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "whocreated")
    private Users user;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "postid")
    private Post post;

	public Long getCommentsid() {
		return commentsid;
	}

	public void setCommentsid(Long commentsid) {
		this.commentsid = commentsid;
	}



	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Timestamp getUpdatTime() {
		return updatTime;
	}

	public void setUpdatTime(Timestamp updatTime) {
		this.updatTime = updatTime;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	
	
}