package com.wellsfargo.stockmarket.loginsignup;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wellsfargo.stockmarket.loginsignup.entity.User;
import com.wellsfargo.stockmarket.loginsignup.service.UserService;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class UserTest {
	
	@Autowired
	private UserService userService;
	
	User user = new User ("u110","p110","u110@gmail.com","user");
	
	String value;
	String actual;
	
	@Test
	@DisplayName("LOGIN PASS CASE")
	public void TestA()throws Exception{
		
		
		userService.addUser(user.getUserName(),user.getPassword(),user.getEmail());
		
		actual = "login succesful";
		value = userService.findbyID( user.getUserName(), user.getPassword());
		assertEquals(actual,value);
		
		
	}
	@Test
	@DisplayName("LOGIN FAIL - INVALID PASSWORD CASE")
	public void TestB()throws Exception{
		
		actual =  "wrong password";
		value = userService.findbyID("u110", "password");
		assertEquals(actual,value);
	
	}
	
	@Test
	@DisplayName("LOGIN FAIL - USER NOT AVAILABLE CASE")
	public void TestC()throws Exception{
		
		actual = "USER NOT PRESENT";
		value = userService.findbyID("userName", "password");
		assertEquals(actual,value);
	}
	
	
	
	@Test
	@DisplayName("ADD USER TEST PASSED")
	public void TestD() throws Exception{
		
		user = userService.addUser("newUser2", "newPassword1", "newemail1");
		assertNotNull(user);
		
	}
	
	@Test
	@DisplayName("ADD USER TEST FAILED USERNAME ALREADY AVAILABLE")
	public void TestE() throws Exception{
		
		user = userService.addUser("newUser", "newPassword", "newemail");
		assertNull(value);
		
		
		
	}
	
	@Test
	@DisplayName("ADD USER TEST FAILED EMAIL ALREADY AVAILABLE")
	public void TestF() throws Exception{
		
		user = userService.addUser("newUser1", "newPassword", "newemail1");
		assertNull(value);
		
	}
	
	
	
	@Test
	@DisplayName("UPDATE USER TEST PASSED")
	public void TestG() throws Exception{
		
		user = userService.updateUser("newUser1", "updatedPassword", "updatedEmail");
		assertNotNull(user);
		
	}
	
	@Test
	@DisplayName("UPDATE USER TEST FAILED")
	public void TestH() throws Exception{
		
		
		user = userService.updateUser("randomUser", "updatedPassword", "updatedEmail");
		assertNotNull(user);
		
	}

}
