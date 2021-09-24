package com.example.demo.dao;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Groups;


public interface GroupsDao extends JpaRepository<Groups, Long> 
{
	
	@Transactional
	@Modifying
	@Query("Delete from Groups g where g.groupId  = :id")
	public void deleteSingleGroupById(@Param("id") Long id);
    
	@Transactional
	@Modifying
	@Query("Update Groups g set g.title = :title where g.groupId  = :id")
	public void updateGroupTitleById(@Param("id") Long id ,@Param("title")String title );
    
}
