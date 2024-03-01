package com.skbit.userservice.userserviceImp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.skbit.userservice.entity.User;
import com.skbit.userservice.exception.ResourceNotFoundException;
import com.skbit.userservice.exception.UserNotFoundException;
import com.skbit.userservice.repository.UserRepository;
import com.skbit.userservice.services.UserService;
@Service
public class UserServiceImp implements UserService{
	
	   @Autowired
	    private UserRepository userRepository;
	
	

	@Override
	public User saveUser(User user ) {
		User finduser= this.userRepository.findUserByEmail(user.getEmail());
		if(finduser != null) {
			
			throw	new  ResourceNotFoundException("user is already exit with  given email id :"+ user.getEmail());
		}
        return this.userRepository.save(user);
		 
	}

	@Override
	public List<User> getAllUser() {
		
		return this.userRepository.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return this.userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException());
	}

	@Override
	public User getUserByUserName(String name) {
		
		 return this.userRepository.findUserByNameContaining(name);
	}

	@Override
	public String removeUser(Integer Id) {
		User user = this.userRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException());
        this.userRepository.delete(user);
		return "User is deleted user successfully given id :" +Id;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = this.userRepository.findUserByEmail(email);
		if(user !=null) {
			return user;
		}
		throw new UserNotFoundException("User not found with given id");
	}

	


	



	

	

}
