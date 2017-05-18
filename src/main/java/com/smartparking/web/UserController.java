package com.smartparking.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartparking.domain.User;
import com.smartparking.services.UserService;
import com.smartphone.vo.UserVO;

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
}
