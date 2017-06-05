package com.smartparking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smartparking.domain.User;

@Controller
@RequestMapping(value="/app/user")
public class UserController extends CrudController<User> {

	public UserController() {
		super(User.class, "user");
	}
	

}
