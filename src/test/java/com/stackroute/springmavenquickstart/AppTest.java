package com.stackroute.springmavenquickstart;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.springmavenquickstart.dao.UserDAO;
import com.stackroute.springmavenquickstart.model.User;



/**
 * Unit test for simple App.
 */
public class AppTest
{
    
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static UserDAO userDAO;
	
	@Autowired
	static User user;
	
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.stackroute");
		context.refresh();
		
		//get the userDAO from context
		userDAO =  (UserDAO) context.getBean("userDAO");
		
		//get the user from context
		
		user = (User)context.getBean("user");
		
	}
	
	@Test
	public void validateUserSuccessTestCase()
	{
		
		boolean flag =  userDAO.validate("John", "password");
		
		
		assertEquals(true, flag);
		
	}
	
	@Test
	public void validateUserFailureTestCase()
	{
		
		boolean flag =  userDAO.validate("Will", "password");
		
		
		assertEquals(false, flag);
		
	}
	
	
	
}
