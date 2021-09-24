package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.NotifictionDao;
import com.example.demo.dtos.NotifcationDto;
import com.example.demo.dtos.NotificationUserPostDto;
import com.example.demo.model.Notifications;

@Service
public class NotificationService 
{
	@Autowired
	NotifictionDao notificationsDao;
    public void saveNotification(NotifcationDto dtos)
    {
    	Notifications  notifications = new Notifications();
    	notifications.setPostId(dtos.getPostId() );
    	notifications.setWhoReacted(dtos.getWhoReacted());
    	notificationsDao.save(notifications);
    }
	 
    
    
       public void usersCommntsNotification()
       {
    	   List<NotificationUserPostDto>  dtos =    notificationsDao.usersCommntsNotification(2);
    	   
    	   System.out.println("  pleasw give us data ");
       }
	
}
