package com.himanshu.spring_rest.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.himanshu.spring_rest.entity.*;

import com.himanshu.spring_rest.entity.User;


public interface UserRepository {

	
	public List<User> getAllUsers();
	
	public User getUser(String userId);

	public User findByEmail(String email);
	
	public User createUser(User user);

	public User updateUser(User user);

	public void deleteUser(User user);
}
