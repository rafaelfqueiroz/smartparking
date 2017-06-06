package com.smartparking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smartparking.domain.Car;
import com.smartparking.services.UserService;

@Controller
@RequestMapping("/app/car")
public class CarController extends CrudController<Car> {

	@Autowired
	private UserService userService;
	
	public CarController() {
		super(Car.class, "car");
	}
	
	@Override
	public String form(Model model) {
		model.addAttribute("car", new Car());
		model.addAttribute("users", userService.getAll());
		return getViewPath("form");
	}
	
	@Override
	@GetMapping("/{id}")
	public String edit(@PathVariable("id") Integer idEntity, Model model) {
		model.addAttribute("car", crudService.get(idEntity));
		model.addAttribute("users", userService.getAll());
		return getViewPath("form");
	}

}
