package com.example.demo.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "friends")
////https://vladmihalcea.com/the-best-way-to-map-a-composite-primary-key-with-jpa-and-hibernate/

public class Freinds  implements Serializable
{
	//@EmbeddedId
	///FriendsID friendsID;
	 @Id 
	 @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	 @GenericGenerator(name = "native",strategy = "native")
	 @Column(name = "friendsid")
	 private Long friendsId;
	 
	 @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "whoisfriend")
	    private Users user;
	 @Column(name = "myfriends")
	 private Long myFriends;
	 
	 
	@Column(name = "time")
	Timestamp whenFriend;

	public Timestamp getWhenFriend() {
		return whenFriend;
	}
	public void setWhenFriend(Timestamp whenFriend) {
		this.whenFriend = whenFriend;
	}
//	public FriendsID getFriendsID() {
//		return friendsID;
//	}
//	public void setFriendsID(FriendsID friendsID) {
//		this.friendsID = friendsID;
//	}
	public Long getFriendsId() {
		return friendsId;
	}
	public void setFriendsId(Long friendsId) {
		this.friendsId = friendsId;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
