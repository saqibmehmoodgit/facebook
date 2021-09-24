package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.GroupsDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.model.Groups;
import com.example.demo.model.Institute;
import com.example.demo.model.Users;



import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
@RestController
@RequestMapping("groups")
public class GroupsController 
{
	@Autowired
	GroupsDao groupsDao;
	@Autowired
	UsersDao userDao;
	@Autowired
	EntityManager  entityManager;
	@GetMapping( path =  "/persist", produces = "application/json")
    public String persistGroup() 
	{
		LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
		Users user = userDao.getById(1L);
		
		
		//Users user2 = userDao.getById(2L);
		
		Groups  gr = new Groups();
		gr.setCreatedDate(timestamp);
		gr.setTitle("C++ Champion");
		//gr.addUser(user);
		///gr.addUser(user2);		
		groupsDao.save(gr);
		
		return "saved";
    }

	@GetMapping( path =  "/get", produces = "application/json")
    public String getGroup() 
	{
	
	Optional<Groups> gr = 	   groupsDao.findById(4L);
		
//	   if(gr.get().getUsers() != null)
//			   {
//		     System.out.println("  this is  nit null " + gr.get().getUsers().size()    );
//			   }
	
		return "saved";
    }

	@GetMapping( path =  "/delete", produces = "application/json")
    public String deleteGroup() 
	{
		groupsDao.deleteSingleGroupById(7L);
		return "DELETED";
    }
	@GetMapping( path =  "/update", produces = "application/json")
    public String updateGroupTitleById() 
	{
		groupsDao.updateGroupTitleById(5L , "React Learner");
		return "Updated";
    }
	
	
	
	
	
	
	
	
	
//	@GetMapping( path =  "/save", produces = "application/json")
//    public Users getInstitute() 
//	{
//		LocalDateTime now = LocalDateTime.now();
//        Timestamp timestamp = Timestamp.valueOf(now);
//        Institute ins = new Institute();
//        ins.setInstituteName("Primerary School ");
//       ins.setPassingYear(timestamp);
//         
//        Users user =        usersDao.getById((long) 2);
//        user.addComment(ins);
//        usersDao.save(user);
//        return user;
//    }
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
	
}
