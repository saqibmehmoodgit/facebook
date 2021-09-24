package com.example.demo.dao;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Location;


public interface LocationDao extends JpaRepository<Location, Long> 
{

	@Transactional
	@Modifying
	@Query(value="insert into  location( city ,state ,street ,country , uid , wrkid) values (?1,?2,?3,?4,?5,?6)  " , nativeQuery=true)
	public void insetrtLocation(@Param("city") String  city , @Param("state") String  state , @Param("street") String  street,
			@Param("country") String  country,	@Param("uid") int uid ,@Param("wrkid") int wrkid);

}
