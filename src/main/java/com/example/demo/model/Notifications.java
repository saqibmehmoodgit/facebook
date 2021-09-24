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

import com.example.demo.dtos.NotificationUserPostDto;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "notification")
@SqlResultSetMapping(
		  name="notificationUserPost",
			classes={
			 @ConstructorResult(
			    targetClass=NotificationUserPostDto.class,
			     columns={
			              @ColumnResult(name="nameUser"),
			              @ColumnResult(name="nameComments") 
			            }
			        )
			    }
			)

			@NamedNativeQuery(name="usersCommntsNotification", query="SELECT u.fname as nameUser,p.title as nameComments "
					+ " FROM post p INNER JOIN  notification n on p.pid = n.postid INNER JOIN user u on n.whoreacted=u.userid"
					+ " WHERE p.pid = :postId", resultSetMapping="notificationUserPost")
public class Notifications 
{
	@Id 
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name = "notifid")
	Long  notifyId;
	
	@Column(name = "postid")
	Long  postId;

	@Column(name = "whoreacted")
	Long  whoReacted;

	
	
	public Long getNotifyId() {
		return notifyId;
	}

	public void setNotifyId(Long notifyId) {
		this.notifyId = notifyId;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Long getWhoReacted() {
		return whoReacted;
	}

	public void setWhoReacted(Long whoReacted) {
		this.whoReacted = whoReacted;
	}
 
	
	
	
}
