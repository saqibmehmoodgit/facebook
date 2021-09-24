package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CommentsDao;
import com.example.demo.dao.GroupsDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.mappers.NotificationDtoMapper;
import com.example.demo.model.Groups;
import com.example.demo.model.Institute;
import com.example.demo.model.Users;
import com.example.demo.posting.UserMakesPostComments;
import com.example.demo.service.CommmentsService;
import com.example.demo.service.NotificationService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
@RestController
@RequestMapping("comments")
public class CommentsController 
{
	@Autowired
	GroupsDao groupsDao;
	@Autowired
	UsersDao userDao;
	@Autowired
	CommentsDao commDao;
	@Autowired
	EntityManager  entityManager;
     @Autowired
	CommmentsService userMksComPost;
     @Autowired
     NotificationService  notificationService;
     @Autowired
     NotificationDtoMapper notificationDtoMapper;
	@PostMapping( path =  "/persistCommPost", produces = "application/json")
    public String persistCommentsOfPost(@RequestBody  UserMakesPostComments userMakesPost) 
	{
		
		notificationService.saveNotification(notificationDtoMapper.giveNotifcationDto(userMakesPost));
		
		
		userMksComPost.userMakeComments(userMakesPost);
        
        
		return "saved";
    }

	
	
	@GetMapping( path =  "/persist", produces = "application/json")
    public String persistGroup() 
	{
		LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
	
        commDao.insetrtComments("wonderful", timestamp,1, 1, 1);
        
        
		return "saved";
    }
	
}
