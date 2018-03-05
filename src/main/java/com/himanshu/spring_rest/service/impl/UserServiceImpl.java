package com.himanshu.spring_rest.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.himanshu.spring_rest.entity.User;
import com.himanshu.spring_rest.exception.BadRequestException;
import com.himanshu.spring_rest.exception.NotFoundException;
import com.himanshu.spring_rest.repository.UserRepository;
import com.himanshu.spring_rest.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository repo;

	UserServiceImpl(UserRepository repo) {
		this.repo = repo;
	}

	@Override
	@Transactional()
	public List<User> getAllUsers() {

		return repo.getAllUsers();
	}

	@Override
	public User getUser(String userId) {
		User user = repo.getUser(userId);
		if (user == null) {
			// TODO
			// throw a runtime exception here which should return 404 to the client
			throw new NotFoundException("User with id " + userId + " doesn't exist!");
		}
		return user;
	}

	@Override
	@Transactional
	public User createUser(User user) {
		// Find if the user exists
		User existingUser = repo.findByEmail(user.getEmail());
		
		if (existingUser != null) {
			// throw a runtime exception which should be returned, like return 400- which
			// says Bad Request
			throw new BadRequestException("User with user email " + user.getEmail() + " already exists");
		}
		return repo.createUser(user);
	}

	@Override
	@Transactional
	public User updateUser(String id, User user) {
		User existingUser = repo.getUser(id);
		if (existingUser == null) {
			throw new NotFoundException("User with id " + id + " doesn't exist!");
		}
		return existingUser;
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		// Find if the user exists
		/*
		User existingUser = repo.getUser(id);
		if (existingUser == null) {
			throw new NotFoundException("User with id " + id + " doesn't exist!");
		}*/
		repo.deleteUser(user);
	}

}
