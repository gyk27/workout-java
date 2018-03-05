package com.workout.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workout.entity.User;
import com.workout.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public long createUser(User user) {
	return	userRepository.save(user).getId();
		
	}

	public User findUser(String email,String password) {
		return userRepository.findByEmail(email);
	}
	
}
