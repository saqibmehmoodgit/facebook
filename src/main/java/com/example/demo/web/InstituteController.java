package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CommentsDao;
import com.example.demo.dao.GroupsDao;
import com.example.demo.dao.InstituteDao;
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
@RequestMapping("institute")
public class InstituteController 
{
//	@Autowired
//	UsersDao userDao;
//	@Autowired
//	CommentsDao commDao;

	@Autowired
	InstituteDao instDao;
//	@Autowired
//	EntityManager  entityManager;

	@GetMapping( path =  "/persist", produces = "application/json")
    public String persistGroup() 
	{
		LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
	
        
        instDao.insetrtInstitute("Oxford University ", timestamp, 1); 
        
        
		return "saved";
    }
	
}
