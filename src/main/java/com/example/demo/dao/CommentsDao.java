package com.example.demo.dao;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Comments;

public interface CommentsDao extends JpaRepository<Comments, Long>
{
	@Transactional
	@Modifying
	@Query(value="insert into  comments( comments ,created ,  uid , postid) values (?1,?2,?3,?4,?5)  " , nativeQuery=true)
	public void insetrtComments(@Param("comments") String  comments , @Param("time")Timestamp time,@Param("child") int child , @Param("uid") int uid ,
			@Param("postid") int postid);
}
