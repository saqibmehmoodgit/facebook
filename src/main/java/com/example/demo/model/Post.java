package com.example.demo.model;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedNativeQuery;

import com.example.demo.dtos.UserNamesDto;
import com.example.demo.dtos.UserPostCommentsDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "post")

/*@SqlResultSetMapping(
  name="userPostComments",
	classes={
	 @ConstructorResult(
	    targetClass=UserPostCommentsDto.class,
	     columns={
	              @ColumnResult(name="fname"),
	              @ColumnResult(name="title"),
	              @ColumnResult(name="comments")
	            }
	        )
	    }
	)

	@NamedNativeQuery(name="usersPstsCommnts", query="SELECT u.fname as firstName,p.title as title, c.comments as comments"
			+ " FROM user u INNER JOIN  friends f on f.myfriends = u.userid INNER JOIN post p on p.whocreated=f.myfriends "
			+ "  INNER JOIN comments c on p.pid = c.postid  WHERE u.userid = :userId", resultSetMapping="userPostComments")
*/
///// group_members gm ON g.group_id = gm.group_id and gm.user_id = :userId

public class Post 
{

	@Id 
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	Long pid;
	String title;
	String description;
	Timestamp time;
	@Column(name = "likes")
	int totalLikes;
	@Column(name = "emoji")
	String image;
	
	
	    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "whocreated")
    private Users user;
	    
	 @OneToMany(
	            mappedBy = "post",
	            cascade = CascadeType.ALL,
	            orphanRemoval = true
	        )
	 private Set<Comments> comments = new HashSet<>(); 
	 
	 public void addComment(Comments comment) {
         comments.add(comment);
         comment.setPost  (this);
     }
  
     public void removeComment(Comments comment) {
         comments.remove(comment);
         comment.setPost (null);
     }

     public  Post(int totalLikes) 
     {
          this.totalLikes = totalLikes;
     }
     public Post() {
		// TODO Auto-generated constructor stub
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public int getTotalLikes() {
		return totalLikes;
	}

	public void setTotalLikes(int totalLikes) {
		this.totalLikes = totalLikes;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Set<Comments> getComments() {
		return comments;
	}

	
	
   


}