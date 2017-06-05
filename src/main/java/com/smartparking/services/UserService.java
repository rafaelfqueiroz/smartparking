package com.smartparking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartparking.domain.Car;
import com.smartparking.domain.User;
import com.smartparking.repositories.UserRepository;

@Service
public class UserService extends CrudService<User>{

	@Autowired
	private UserRepository userRepository;
	
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

	public User findUser(Integer userId) {
		if (userId == null) {
			return null;
		}
		User user = userRepository.findByIdAndActiveTrue(userId);
		return user;
	}

	public String findUserTokenFromCar(Car car) {
		User user = userRepository.findUserByCar(car);
		return user.getToken();
	}
}
