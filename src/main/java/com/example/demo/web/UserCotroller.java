package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PostDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.dtos.UserPostDto;
import com.example.demo.dtos.UserNamesDto;
import com.example.demo.mappers.UserDtoMapper;
import com.example.demo.model.Comments;
import com.example.demo.model.Groups;
import com.example.demo.model.Institute;
import com.example.demo.model.Post;
import com.example.demo.model.Users;

import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
@RestController
@RequestMapping("users")
//@RequiredArgsConstructor
public class UserCotroller 
{
	@Autowired
	UsersDao usersDao;
	
	@Autowired
	PostDao postDao;
	@Autowired
	EntityManager  entityManager;
	
	@Autowired

	UserDtoMapper userDtoMapper;
	

	@PostMapping(path = "/userSave", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public UserPostDto userSave(UserNamesDto userNamesDto) 
	{
	 
		System.out.println("   this is  userPostDtos" + userNamesDto.getPic().getSize());
	
		
		Users users =     usersDao.findAllUserPostsComments(1L);
    	return userDtoMapper.toProductDTO(users);
 
	}

	@GetMapping( path =  "/findAllUsers", produces = "application/json")
    public List<UserNamesDto>  findAllUsers() 
	{
		      
        return userDtoMapper.findAllUser(usersDao.findUsersColoumn());
    }

	
	@GetMapping( path =  "/userCommentsPosts", produces = "application/json")
    public UserPostDto userPostsComments() 
	{
	  Users users =     usersDao.findAllUserPostsComments(1L);
	  return userDtoMapper.toProductDTO(users);
 }

	
	@GetMapping( path =  "/saveUsers", produces = "application/json")
    public String  saveUsers() 
	{
		LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
		Users entity = new Users();
		entity.setFirstName("junaid");
		entity.setLastName("aamir");
		entity.setBigPicture("bigPic");
		entity.setPicture("pic");
		entity.setReligin("Islam");
		entity.setSmallPicture("smallPic");
		entity.setBirthDate(timestamp);
		entity.setUpdatTime(timestamp);
		usersDao.save(entity );
        return "saved succesfully ";
    }
	/////////////////  797250311984336
	

	
	
	@GetMapping( path =  "/saveUserPosts", produces = "application/json")
    public void getBook() 
	{
		LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
		Users entity = new Users();
		entity.setFirstName("junaid");
		entity.setLastName("aamir");
		entity.setBigPicture("bigPic");
		entity.setPicture("pic");
		entity.setReligin("Islam");
		entity.setSmallPicture("smallPic");
		entity.setBirthDate(timestamp);
		entity.setUpdatTime(timestamp);
		
		Post post = new Post();
		post.setDescription(" going uk  description");
		post.setImage(" no image ");
		post.setTime(timestamp);
		post.setTitle("going uk title");
		post.setTotalLikes(2);
		post.setUser(entity);
		
		entity.addPost(post);
		
		Post post2 = new Post();
		post2.setDescription(" going pk  description");
		post2.setImage(" no image ");
		post2.setTime(timestamp);
		post2.setTitle("going pk title");
		post2.setTotalLikes(2);
		post2.setUser(entity);
		
		entity.addPost(post2);
		
		
		Comments comments = new Comments ();
		comments.setComments("going uk commnets");
		comments.setUpdatTime(timestamp);
		comments.setPost(post);
		comments.setUser(entity);
		post.addComment(comments);
		Comments comments2 = new Comments ();
		comments2.setComments("going uk2 commnets");
		comments2.setUpdatTime(timestamp);
		comments2.setPost(post);
		comments2.setUser(entity);
		post.addComment(comments2);
		
		Comments comments3 = new Comments ();
		comments3.setComments("going pk commnets");
		comments3.setUpdatTime(timestamp);
		comments3.setPost(post2);
		comments3.setUser(entity);
		post2.addComment(comments3);
		
		usersDao.save(entity );
		postDao.save(post2);
		postDao.save(post);
     ///   return usersDao.getById((long) 2);
    }

	@GetMapping( path =  "/save", produces = "application/json")
    public Users getInstitute() 
	{
		LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        Institute ins = new Institute();
        ins.setInstituteName("Primerary School ");
       ins.setPassingYear(timestamp);
         
        Users user =        usersDao.getById((long) 2);
      //  user.addComment(ins);
        usersDao.save(user);
        return user;
    }
	@GetMapping( path =  "/lazy", produces = "application/json")
    public List<Users> getLazyInstitute() 
	{     
      //  Users user =        usersDao.getById((long) 2);
        List<Users> entity = entityManager.createQuery("select e from Users e join fetch e.institute where e.userId = :id", Users.class)
        		.setParameter("id", 2L)
        		.getResultList();
        return entity;
    }

	@GetMapping( path =  "/findAll", produces = "application/json")
    public List<Institute> getInstitutes() 
	{
		  if(entityManager != null)
		  {
//        List<Institute> comments = entityManager.createQuery(
//        	    "select pc " +
//        	    "from Institute pc " +
//        	    "where users.userId = :postId", Institute.class)
//        	.setParameter( "postId", 2L )
//        	.getResultList();
//        
        
			  List<Institute> comments = entityManager.createQuery(
		        	    "select pc " +
		        	    "from Institute pc  " +
		        	    "where users.userId = :postId", Institute.class)
		        	.setParameter( "postId", 2L )
		        	.getResultList();
		        
			  
			  
        
		  return comments;
		  }
		  return null;
    }
	
	@GetMapping( path =  "/saveGroup", produces = "application/json")
    public String saveGroups() 
	{
		LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        Users user =        usersDao.getById((long) 2);
		Groups  gr = new Groups();
		gr.setCreatedDate(timestamp);
		gr.setTitle("React Champion");
	//	gr.addUser(user);
         
     
       /// user.addGroup(gr);
        usersDao.save(user);
        
        
        return "saving groups and users ";
    }
	
	
	
	
	
	@GetMapping( path =  "/userInsititute", produces = "application/json")
    public Set<Users> userInstitute() 
	{
	  Set<Users> users =     usersDao.findUserInstitute(1L);
	  return users;

	  
        
        
    }
//UserDto

	@GetMapping( path =  "/userDto", produces = "application/json")
    public UserPostDto userDto() 
	{
	  	Optional<Users> users =	usersDao.findById(1L);
		
	  	UserPostDto   userDto =    null;///    userDtoMapper.toProductDTO(users.get());
	  	return userDto;

	  
        
        
    }
	
	
}
