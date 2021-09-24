package com.example.demo.dtos;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Comments;
import com.example.demo.model.Groups;
import com.example.demo.model.Institute;
import com.example.demo.model.Post;
import com.example.demo.model.Workplace;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//import lombok.Data;

///@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserNamesDto 
{
	String bigPicture;
	String smallPicture;
    String religin;
	String firstName;
	String lastName;
	String picture;

	private MultipartFile pic;	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getBigPicture() {
		return bigPicture;
	}
	public void setBigPicture(String bigPicture) {
		this.bigPicture = bigPicture;
	}
	public String getSmallPicture() {
		return smallPicture;
	}
	public void setSmallPicture(String smallPicture) {
		this.smallPicture = smallPicture;
	}
	public String getReligin() {
		return religin;
	}
	public void setReligin(String religin) {
		this.religin = religin;
	}
	public MultipartFile getPic() {
		return pic;
	}
	public void setPic(MultipartFile pic) {
		this.pic = pic;
	}
	
	
	
	
}
