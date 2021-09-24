package com.example.demo.service;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CommentsDao;
import com.example.demo.dao.PostDao;
import com.example.demo.model.Post;
import com.example.demo.posting.UserMakesPostComments;
import com.example.demo.posting.UserPost;

@Service
public class PostsService 
{
	
	@Autowired
	PostDao postDao;
	
	
	//CommentsDao  commentsDao;

	public ResponseEntity<String> userMakeComments(UserPost userPost)
	{
		Instant instant = Instant.now();
		Timestamp timestamp = Timestamp.from(instant);
		postDao.insetrtPost(userPost.getTitle() ,  "description"  , timestamp,10,userPost.getImage() ,userPost.getWhoCreated());
		return ResponseEntity.status(HttpStatus.OK).body("Your Post has been saved")  ;
	}
	public ResponseEntity<String> userUpdateTotalLikes(Long id)
	{
		Post count =postDao.findPostLiking(id);
		postDao.setUpdateForTotalLikes(count.getTotalLikes()+1,id);
		return ResponseEntity.status(HttpStatus.OK).body("Your Post has been saved")  ;
	}
	
}
