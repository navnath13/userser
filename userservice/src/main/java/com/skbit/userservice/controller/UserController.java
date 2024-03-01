package com.skbit.userservice.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skbit.userservice.entity.User;
import com.skbit.userservice.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService usersService;
	
	
	
	// to create new user
	@PostMapping("/")
	public ResponseEntity<User> createUser(@Validated @RequestBody User user ){
		User saveUser = this.usersService.saveUser(user);
		
		return new ResponseEntity<User>(saveUser,HttpStatus.CREATED);
	}
	
	
	// getting all user
   @GetMapping("/")
	public ResponseEntity<List<User>> getAllUser() {
	List<User> allUser = this.usersService.getAllUser();
	return new ResponseEntity<List<User>>(allUser,HttpStatus.OK);
	
	}
   
   
   @GetMapping("/{id}")
	public ResponseEntity<User> saveUser(@PathVariable Integer id ) {
	User allUser = this.usersService.getUserById(id);
	return new ResponseEntity<User>(allUser,HttpStatus.OK);
	
	}
   @GetMapping("/name/{name}")
	public ResponseEntity<User> getUser(@PathVariable String name ) {
	User allUser = this.usersService.getUserByUserName(name);
	return new ResponseEntity<User>(allUser,HttpStatus.OK);
	
	}
   @GetMapping("/email/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String email ) {
	User allUser = this.usersService.getUserByEmail(email);
	return new ResponseEntity<User>(allUser,HttpStatus.OK);
	
	}
   @DeleteMapping("/{id}")
	public ResponseEntity<String> getRemoveUser(@PathVariable Integer id ) {
	String removeUser = this.usersService.removeUser(id);
	return new ResponseEntity<String> (removeUser,HttpStatus.OK);
	}
	

}
