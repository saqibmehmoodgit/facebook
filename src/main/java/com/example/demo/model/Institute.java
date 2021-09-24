package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name = "institute")
public class Institute
{
	@Id 
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name = "instititeid")
	Long  instititeid;
	@Column(name = "name")
	String name;
	
	@Column(name = "institute")
	String instituteName;
	
	@JsonFormat(pattern="dd-MMM-yyyy HH:mm:ss")
	@Column(name = "passingYear")
	Timestamp passingYear;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "whocreated")
    private Users users;



	public Long getInstititeid() {
		return instititeid;
	}



	public void setInstititeid(Long instititeid) {
		this.instititeid = instititeid;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	



	public String getInstituteName() {
		return instituteName;
	}



	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}



	public Timestamp getPassingYear() {
		return passingYear;
	}



	public void setPassingYear(Timestamp passingYear) {
		this.passingYear = passingYear;
	}



	public Users getUsers() {
		return users;
	}



	public void setUsers(Users user) {
		this.users = user;
	}
	

}