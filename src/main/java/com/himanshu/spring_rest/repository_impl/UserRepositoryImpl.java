package com.himanshu.spring_rest.repository_impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.himanshu.spring_rest.entity.User;
import com.himanshu.spring_rest.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	EntityManager em;

	public List<User> getAllUsers() {
		TypedQuery<User> query=em.createNamedQuery("User.findAll",User.class);
		return query.getResultList();
	}

	public User getUser(String userId) {

		return em.find(User.class, userId);
	}

	public User createUser(User user) {

		em.persist(user);;
		return user;
	}

	public User updateUser(User user) {

		return em.merge(user);
	}

	public void deleteUser(User user) {
		em.remove(user);
	}

	@Override
	public User findByEmail(String email) {
		
		return null;
	}
}
