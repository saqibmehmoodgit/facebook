package com.example.demo.dao;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.UserStatus;
public interface UsersStatusDao extends JpaRepository<UserStatus, Long> 
{

	@Transactional
	@Modifying
	@Query(value="insert into  userstatus(status , updatetime , uid ) values (?1,?2,?3)  " , nativeQuery=true)
	public void insetrtComments(@Param("status") int  status , @Param("time")Timestamp time, @Param("uid") int uid);  

}
