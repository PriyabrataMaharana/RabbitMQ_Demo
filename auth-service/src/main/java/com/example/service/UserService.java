package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public void addUser(User user) {
		repository.save(user);
	}
}
