package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.FreindsDao;
import com.example.demo.dao.GenderDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.model.Freinds;
import com.example.demo.model.FriendsID;
import com.example.demo.model.Users;

import java.sql.Timestamp;
import java.time.LocalDateTime;
@RestController
@RequestMapping("gender")
public class GenderController {
	@Autowired
	GenderDao genderDao;
	
	@GetMapping( path =  "/load", produces = "application/json")
    public  String getBook() 
	{
		genderDao.findById(1L);
		
        return "loaded";
    }
}
