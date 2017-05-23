package com.smartparking.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartparking.domain.User;
import com.smartparking.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	@Transactional
	public User updateToken(User user) {
		User userBd = userRepository.findByLogin(user.getLogin());
		userBd.setToken(user.getToken());
		userRepository.save(userBd);
		return userBd;
	}

	public User findUserByLoginAndPassword(User user) {
		return userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword());
	}

	public List<User> findUsers() {
		return (List<User>) userRepository.findAll();
	}

	public User findUser(Integer userId) {
		if (userId == null) {
			return null;
		}
		User user = userRepository.findOne(userId);
		return user;
	}
}
