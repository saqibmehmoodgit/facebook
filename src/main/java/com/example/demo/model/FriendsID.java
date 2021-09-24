package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FriendsID implements Serializable
{

	 @Column(name = "userid")
	 private Long userId;
	 
	 @Column(name = "friendid")
	 private Long friendID;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getFriendID() {
		return friendID;
	}

	public void setFriendID(Long friendID) {
		this.friendID = friendID;
	}

	public FriendsID() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((friendID == null) ? 0 : friendID.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FriendsID other = (FriendsID) obj;
		if (friendID == null) {
			if (other.friendID != null)
				return false;
		} else if (!friendID.equals(other.friendID))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	 
	 
}
