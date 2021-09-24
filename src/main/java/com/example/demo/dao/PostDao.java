package com.example.demo.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Post;
import com.example.demo.model.Users;

public interface PostDao extends JpaRepository<Post, Long>
{
	
	
	@Transactional
	@Modifying
	@Query(value="insert into  post( title,description, time , likes , emoji , whocreated) values (?1,?2,?3,?4,?5,?6)  " , nativeQuery=true)
	public void insetrtPost(@Param("title") String  title ,  @Param("description") String  description  , 
			@Param("time")Timestamp time,@Param("totalLikes") int totalLikes ,@Param("image") String  image ,
			@Param("whocreated") int whocreated);
	

	@Query("SELECT new Post(p.totalLikes) FROM Post p where p.pid = :id ")
	Post findPostLiking(@Param("id") Long id);
	
	@Transactional
	@Modifying
	@Query("update Post p set p.totalLikes = :likes where p.pid = :id")
	int setUpdateForTotalLikes(@Param("likes") Integer status, @Param("id") Long id);

}
