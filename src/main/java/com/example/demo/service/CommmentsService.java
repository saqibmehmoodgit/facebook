package com.example.demo.service;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CommentsDao;
import com.example.demo.posting.UserMakesPostComments;

@Service
public class CommmentsService 
{
	
	@Autowired
	CommentsDao  commentsDao;

	public void userMakeComments(UserMakesPostComments userMksComments)
	{
		Instant instant = Instant.now();
		Timestamp timestamp = Timestamp.from(instant);
		commentsDao. insetrtComments( userMksComments.getComments()   , timestamp ,1 , userMksComments.getWholikes(), userMksComments.getPostid());
		
	}
	
}
