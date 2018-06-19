package com.stackroute.springmavenquickstart.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.stackroute.springmavenquickstart.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean validate(String username, String password) {
		
		User user=(User)sessionFactory.getCurrentSession().createQuery("from User where username='"+username+"' and password='"+password+"'").uniqueResult();
		
		if(user!=null)
			return true;
		else
			return false;
	}
	
	

}
