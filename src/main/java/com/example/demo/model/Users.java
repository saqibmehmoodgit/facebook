package com.example.demo.model;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@Entity
@Table(name = "user")
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
//@JsonInclude(Include.NON_NULL)
/////  userid  myfriends  whocreated  postid

public class Users 
{

	@Id 
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name = "userid")  
	Long  userId;
	@Column(name = "fname")
	String firstName; 
	@Column(name = "lname")
	String lastName; 
	@JsonFormat(pattern="dd-MMM-yyyy HH:mm:ss")
	@Column(name = "birthdate")
	Timestamp birthDate; 
	@Column(name = "bigpic")
	String bigPicture;
	@Column(name = "smallpic")
	String smallPicture;
	@Column(name = "pic")
	String picture;
	@Column(name = "religion")
	String religin;
	@JsonFormat(pattern="dd-MMM-yyyy HH:mm:ss")
	@Column(name = "updatetime")
	Timestamp updatTime;
	
	
	
	public Users(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		
	}

	
	
	///////////  Institute
//	 @JsonIgnore
	 @OneToMany(mappedBy = "user", 
		        cascade = CascadeType.ALL,
		        orphanRemoval = true)
		    private Set<Post> post = new HashSet<>();
		 
		    public void addPost(Post pos) {
		    	post.add(pos);
		    	pos.setUser(this);
		    }
		 
		    public void removePost(Post pos) {
		    	post.remove(pos);
		    	pos.setUser(null);
		    }
	
	
	
			///////////  Comments
			////@JsonIgnoreProperties("user")
	//		 @JsonIgnore
			@OneToMany(mappedBy = "user", 
				        cascade = CascadeType.ALL,
				        orphanRemoval = true)
				    private Set<Comments> comments = new HashSet<>();
				 
				    public void addComment(Comments comment) {
				    	comments.add(comment);
				    	comment.setUser(this);
				    }
				 
				    public void removeComment(Comments comment) {
				    	comments.remove(comment);
				    	comment.setUser(null);
				    }
			
	//////////////////////////
		//		    @JsonIgnore
		    @ManyToMany(mappedBy = "users" ,cascade = CascadeType.PERSIST)
		    private Set<Groups> groups = new HashSet<>();
		    
			
			 public void addGroup(Groups group)
			  { 
			   groups.add(group); //
			  group.getUsers().add(this); // // 
			  } // // 
			 public void removeGroups(Groups
			  group) { 
				 //
				 groups.remove(group); // 
				 group.getUsers().remove(this); // 
				 }
			 
			 
		    //////////////////////////////
		    
//			 @OneToMany(mappedBy = "users" ,cascade = CascadeType.PERSIST)
//			    private Set<Location> location = new HashSet<>();
//			    
//				
//				 public void addLocation(Location loction)
//				  { 
//					 location.add(loction); //
//					 loction.setUser(this); // // 
//				  } // // 
//				 public void removeLocation(Location loction) { 
//					 //
//					 location.remove(loction); // 
//					 loction.setUser(null); // 
//					 }
//				 
			 
			 ////////////////
			     // @JsonIgnore
				 @OneToMany(mappedBy = "user" ,cascade = CascadeType.PERSIST)
				    private Set<Workplace> workplace = new HashSet<>();
				    
					
					 public void addWorkplace(Workplace wrkplace)
					  { 
						 workplace.add(wrkplace); //
						 wrkplace.setUser(this); // // 
					  } // // 
					 public void removeWorkplace(Workplace wrkplace) { 
						 //
						 workplace.remove(wrkplace); // 
						 wrkplace.setUser(null); // 
						 }
					 
				 
				 ////////////////
			///////////  Institute
						//@JsonIgnoreProperties("users")
					    /// @JsonIgnore
						 @OneToMany(mappedBy = "users", 
							        cascade = CascadeType.ALL,
							        orphanRemoval = true ,fetch = FetchType.LAZY)
							    private List<Institute> institute = new ArrayList<>();
							 
							    public void addInsitute(Institute institut) {
							    	institute.add(institut);
							    	institut.setUsers(this);
							    }
							 
							    public void removeInsitute(Institute institut) {
							    	institute.remove(institut);
							    	institut.setUsers(null);
							    }
		/////////////////////////////////////////
							    @OneToMany(mappedBy = "user", 
								        cascade = CascadeType.ALL,
								        orphanRemoval = true)
								    private Set<Freinds> freinds = new HashSet<>();
								 
								    public void addPost(Freinds friend) {
								    	freinds.add(friend);
								    	friend.setUser(this);
								    }
								 
								    public void removePost(Freinds friend) {
								    	freinds.remove(friend);
								    	friend.setUser(null);
								    }   
							  /////////////////  
							    
		    
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Set<Groups> getGroups() {
		return groups;
	}

	public void setGroups(Set<Groups> groups) {
		this.groups = groups;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
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


	public Timestamp getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
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


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public String getReligin() {
		return religin;
	}


	public void setReligin(String religin) {
		this.religin = religin;
	}


	public Timestamp getUpdatTime() {
		return updatTime;
	}


	public void setUpdatTime(Timestamp updatTime) {
		this.updatTime = updatTime;
	}

	public Set<Post> getPost() {
		return post;
	}

	public Set<Comments> getComments() {
		return comments;
	}


	


}
