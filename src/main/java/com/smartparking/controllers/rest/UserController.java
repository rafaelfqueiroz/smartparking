package com.smartparking.controllers.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartparking.domain.User;
import com.smartparking.services.UserService;
import com.smartparking.vo.UserVO;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/*
	 * Creates a new user
	 */
	@PostMapping(value="/")
	public ResponseEntity<UserVO> create(@RequestBody UserVO userVO) {
		userService.save(new User(userVO));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	/**
	 * Verify if the user is authorized according with its login and password.
	 */
	@PostMapping(value="/auth")
	public ResponseEntity<UserVO> authorized(@RequestBody UserVO userVO) {
		User user = userService.findUserByLoginAndPassword(new User(userVO));
		
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Updates the token for the user received as parameter.
	 * @param userVO
	 * @return
	 */
	@PutMapping(value="/token")
	public ResponseEntity<UserVO> updateToken(@RequestBody UserVO userVO) {
		userService.updateToken(new User(userVO));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Get all users
	 */
	@GetMapping(value="/")
	public ResponseEntity<List<UserVO>> users(@PathVariable("id") Integer userId) {
		List<UserVO> usersVO = userService.findUsers()
				.stream().map(UserVO::new).collect(Collectors.toList());
		return new ResponseEntity<>(usersVO, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserVO> user(@PathVariable("id") Integer userId) {
		User user = userService.findUser(userId);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new UserVO(user), HttpStatus.OK);
	}
}
