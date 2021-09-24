package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Freinds;
import com.example.demo.model.Gender;
public interface GenderDao extends JpaRepository<Gender, Long> 
{

    

}

