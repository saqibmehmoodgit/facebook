package com.example.demo.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Users;

public interface UsersDao extends JpaRepository<Users, Long> {

	@Query("SELECT  u FROM Users u JOIN FETCH u.post up JOIN FETCH up.comments pc   WHERE u.userId=:userId")
	Users findAllUserPostsComments(@Param("userId") long userId);

	@Query("SELECT  u FROM Users u JOIN FETCH u.institute i    WHERE u.userId=:userId")
	Set<Users> findUserInstitute(@Param("userId") long userId);

	@Query("SELECT new Users(u.firstName, u.lastName) FROM Users u ")
	List<Users> findUsersColoumn();
}
