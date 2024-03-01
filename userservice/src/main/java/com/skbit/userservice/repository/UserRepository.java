package com.skbit.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skbit.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	public User findUserByNameContaining(String name);
	public User findUserByEmail(String name);

}
