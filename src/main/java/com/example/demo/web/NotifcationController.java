package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.UserNamesDto;
import com.example.demo.dtos.UserPostDto;
import com.example.demo.model.Users;
import com.example.demo.service.NotificationService;
@RestController
@RequestMapping("notifcationController")
public class NotifcationController {

	@Autowired
	NotificationService  notificationService;
	
	@PostMapping(path = "/notiy", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public UserPostDto userSave(UserNamesDto userNamesDto) 
{
 
	System.out.println("   this is  userPostDtos" + userNamesDto.getPic().getSize());

	
return null;

}

	@PostMapping(path = "/notifications")
	public UserPostDto NotificationService() 
{
		
		notificationService.usersCommntsNotification();
 
///	System.out.println("   this is  userPostDtos" + userNamesDto.getPic().getSize());

	
return null;

}

	
	

}
