package com.himanshu.spring_rest.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.himanshu.spring_rest.entity.User;

public interface UserService {

	public List<User> getAllUsers();
	public User getUser(String userId);
	public User createUser(User user);
	public User updateUser(String id, User user);
	public void deleteUser(User user);
}
