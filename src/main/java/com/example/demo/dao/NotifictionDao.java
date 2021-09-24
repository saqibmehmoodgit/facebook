package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dtos.NotificationUserPostDto;
import com.example.demo.model.Freinds;
import com.example.demo.model.Notifications;

public interface NotifictionDao extends JpaRepository<Notifications, Long> 
{
	 @Query(name = "usersCommntsNotification", nativeQuery = true)
	List<NotificationUserPostDto> usersCommntsNotification(@Param("postId") Integer postId);

	
}
