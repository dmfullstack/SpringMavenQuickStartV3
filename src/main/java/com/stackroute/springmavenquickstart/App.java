package com.stackroute.springmavenquickstart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.springmavenquickstart.config.AppConfig;
import com.stackroute.springmavenquickstart.dao.UserDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
       
       UserDAO userDAO=(UserDAO)context.getBean("userDAO");
       //should return true
       System.out.println(userDAO.validate("John", "password"));
       //should return false
       System.out.println(userDAO.validate("Will", "password"));
       
    }
}
