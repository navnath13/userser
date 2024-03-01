package com.skbit.userservice.services;

import java.util.List;

import com.skbit.userservice.entity.User;

public interface UserService {
	
	
	
	//user operation
	//create user
	User saveUser(User user);
	
	
	//getting all user
   List<User> getAllUser();
   
   User getUserById(Integer id);
   
   User getUserByUserName(String name);
   String removeUser(Integer Id);
   User getUserByEmail(String email);




}
