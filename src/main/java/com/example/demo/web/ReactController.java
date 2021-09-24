package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UsersDao;
import com.example.demo.model.Groups;
import com.example.demo.model.Institute;
import com.example.demo.model.Users;



import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.websocket.server.PathParam;
@RestController
@CrossOrigin
@RequestMapping("react")
public class ReactController 
{
	@Autowired
	UsersDao usersDao;
	@Autowired
	EntityManager  entityManager;
	

	
	@GetMapping( path =  "/get", produces = "application/json")
    
	public List<com.example.demo.model.Tutorial> getBook() 
	{
		
		System.out.println("  this is  calling for get ");
		 List<com.example.demo.model.Tutorial> tutorialList = new ArrayList<>();
		 com.example.demo.model.Tutorial tutorial = new com.example.demo.model.Tutorial();
		 tutorial.setId(1);
		 tutorial.setDescription(" lets go england  ");
		 tutorial.setPublished(true);
		 tutorial.setTitle("  going to england title   ");
		 tutorialList.add(tutorial);
		 
		 com.example.demo.model.Tutorial tutorial1 = new com.example.demo.model.Tutorial();
		 tutorial1.setDescription("   lets go to dubai ");
		 tutorial1.setId(2);
		 tutorial1.setPublished(false);
		 tutorial1.setTitle(" dubai and subai  ");
		 tutorialList.add(tutorial1);
		 
		 
		 return tutorialList;
	}  ///create
	////  getById
	

	@GetMapping( path =  "/getById/{id}", produces = "application/json")
    
	public com.example.demo.model.Tutorial getById(@PathVariable int id) 
	{
		
		System.out.println("  getById  , and this is parameter  " + id);
		 com.example.demo.model.Tutorial tutorial = new com.example.demo.model.Tutorial();
		 tutorial.setId(1);
		 tutorial.setDescription(" lets go england  ");
		 tutorial.setPublished(true);
		 tutorial.setTitle("  going to england title   ");
		 
		
		 
		 return tutorial;
	}
	
	
	
	@PostMapping( path =  "/create", produces = "application/json")
    public List<com.example.demo.model.Tutorial> putTutorial(@RequestBody com.example.demo.model.Tutorial tutrial ) 
	{
		System.out.println("  this is being called " + tutrial.getDescription());
		 List<com.example.demo.model.Tutorial> tutorialList = new ArrayList<>();
		 com.example.demo.model.Tutorial tutorial = new com.example.demo.model.Tutorial();
		 tutorial.setDescription("desc1");
		 tutorial.setPublished(true);
		 tutorial.setTitle("title 1 ");
		 tutorialList.add(tutorial);
		 
		 com.example.demo.model.Tutorial tutorial1 = new com.example.demo.model.Tutorial();
		 tutorial1.setDescription("desc 2");
		 tutorial1.setPublished(false);
		 tutorial1.setTitle("title 2 ");
		 tutorialList.add(tutorial1);
		 
		 
		 return tutorialList;
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
     //   user.addComment(ins);
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
		//gr.addUser(user);
         
     
     ///   user.addGroup(gr);
        usersDao.save(user);
        
        
        return "saving groups and users ";
    }
	@GetMapping( path =  "/userCommentsPosts", produces = "application/json")
    public String userPostsComments() 
	{
		/*
		 * Set<Users> users = usersDao.findAllUserPostsComments(1L);
		 * 
		 * users.forEach( u -> { System.out.println(" "+ u.getFirstName());
		 * u.getPost().forEach( p -> {
		 * 
		 * System.out.print( "    "+ p.getTitle());
		 * 
		 * p.getComments().forEach( c-> { System.out.print( "    "+ c.getComments()); }
		 * 
		 * ); System.out.println(); } );
		 * 
		 * 
		 * 
		 * // System.out.println(" "+ u.getFirstName() + " post " + u.getPost().
		 * get(0).getTitle() + " " + u.getPost().get(1).getTitle() + " "+
		 * u.getComments().get(0).getComments() ); }
		 * 
		 * 
		 * );
		 */
	   
	  
        
        return "saving groups and users ";
    }
	
}
