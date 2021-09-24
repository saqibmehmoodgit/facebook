package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CommentsDao;
import com.example.demo.dao.GroupsDao;
import com.example.demo.dao.PostDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.model.Groups;
import com.example.demo.model.Institute;
import com.example.demo.model.Users;
import com.example.demo.posting.UserPost;
import com.example.demo.service.PostsService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
@RestController
@RequestMapping("post")
public class PostController 
{
//	@Autowired
//	GroupsDao groupsDao;
//	@Autowired
//	UsersDao userDao;
//	@Autowired
//	CommentsDao commDao;
//	@Autowired
//	EntityManager  entityManager;
	@Autowired
	PostsService postService;
	
	@PostMapping( path =  "/savePost", produces = "application/json")
    public ResponseEntity<String> persistPosts(@RequestBody UserPost userPost) 
	{
	    return postService.userMakeComments(userPost);
    }
	
	
	
	@GetMapping(value = "/like/{id}")
	
	public ResponseEntity<String> likeByUser(@PathVariable("id") long id) {
	    
		return postService.userUpdateTotalLikes(id);
		
	}
}
