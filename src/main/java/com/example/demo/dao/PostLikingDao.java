package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.model.PostLiking;
public interface PostLikingDao extends JpaRepository<PostLiking, Long>
{
	@Transactional
	@Modifying
	@Query(value="insert into  post( wholike ,postid) values (?1,?2)  " , nativeQuery=true)
	public void insetrtPostLiking(@Param("wholike") int whoLike  ,
			@Param("postid") int postid);
}
