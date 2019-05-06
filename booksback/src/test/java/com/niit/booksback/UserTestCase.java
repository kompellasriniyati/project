package com.niit.booksback;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.booksback.dao.UserDAO;
import com.niit.booksback.model.User;

public class UserTestCase {
     
	static UserDAO userDao;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com");
		userDao = (UserDAO)context.getBean("userDao");
	}

@Test
public void registerUserTest()
{
	User userdetail=new User();
	userdetail.setEmailid("user@email.com");
	userdetail.setPassword("password");
	userdetail.setRole("User");
	userdetail.setFirstname("sri");
	userdetail.setLastname("niyati");
	
	assertTrue("Problem in Registering UserDetail in Database",userDao.registerUser(userdetail));
}

	
}



