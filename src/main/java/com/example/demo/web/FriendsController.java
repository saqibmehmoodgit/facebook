package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.FreindsDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.model.Freinds;
import com.example.demo.model.FriendsID;
import com.example.demo.model.Users;

import java.sql.Timestamp;
import java.time.LocalDateTime;
@RestController
@RequestMapping("friends")
public class FriendsController {
	@Autowired
	FreindsDao friendDao;
	
	@GetMapping( path =  "/simple", produces = "application/json")
    public Freinds getBook() 
	{
		LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        FriendsID friendsid = new FriendsID();
        friendsid.setFriendID((long) 3);
        friendsid.setUserId((long) 2);
        
        Freinds entity = new Freinds();
		//entity.setFriendsID(friendsid);
		entity.setWhenFriend(timestamp);
		friendDao.save(entity );
		
		
        return friendDao.getById((long) 2);
    }
}
