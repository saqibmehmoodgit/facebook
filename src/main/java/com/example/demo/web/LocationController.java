package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CommentsDao;
import com.example.demo.dao.GroupsDao;
import com.example.demo.dao.LocationDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.model.Groups;
import com.example.demo.model.Institute;
import com.example.demo.model.Users;



import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
@RestController
@RequestMapping("location")
public class LocationController 
{
//	@Autowired
//	GroupsDao groupsDao;
//	@Autowired
//	UsersDao userDao;
//	@Autowired
//	CommentsDao commDao;
//	
//	@Autowired
//	EntityManager  entityManager;
//	
	@Autowired
	LocationDao loDao;
	
	@GetMapping( path =  "/persist", produces = "application/json")
    public String persistGroup() 
	{
		LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
	
        loDao.insetrtLocation("Lahore", "Punjab","downStreet", "Paksitan", 1,1);
        
		return "saved";
    }
	
}
