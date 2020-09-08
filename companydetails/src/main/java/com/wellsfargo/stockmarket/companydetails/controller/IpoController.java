package com.wellsfargo.stockmarket.loginsignup.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.wellsfargo.stockmarket.loginsignup.entity.User;
import com.wellsfargo.stockmarket.loginsignup.service.UserService;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/login")
	public List<String> login(@RequestParam(required = false) String username,
			@RequestParam(required = false) String password) {

		List<String> map1 = new ArrayList<String>();
		map1.add(userService.findbyID(username, password));
		return map1;

	}

	@RequestMapping("/newUser")
	public User addUser(@RequestParam(required = false) String username,
			@RequestParam(required = false) String password, @RequestParam(required = false) String email) {

		   return userService.addUser(username, password, email);
	}

	@RequestMapping("/update")
	public User update(@RequestParam(required = false) String username, @RequestParam(required = false) String password,
			@RequestParam(required = false) String email)  {

		return userService.updateUser(username, password, email);

	}
}