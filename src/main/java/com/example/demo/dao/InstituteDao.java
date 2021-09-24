package com.example.demo.dao;

import java.sql.Timestamp;

import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Institute;


public interface InstituteDao extends JpaRepository<Institute, Long> 
{

	
	@Transactional
	@Modifying
	@Query(value="insert  into institute(name, passyear, uid) values (?1, ?2, ?3)  " , nativeQuery=true)
	public void insetrtInstitute(@Param("name") String  name , @Param("time")Timestamp time,@Param("uid") int uid );

}
