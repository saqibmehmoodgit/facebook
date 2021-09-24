package com.example.demo.dtos;

import javax.persistence.Column;

public class NotifcationDto 
{

	private Long  postId;
	private Long  whoReacted;
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
