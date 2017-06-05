package com.smartparking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smartparking.domain.ParkingLot;

@Controller
@RequestMapping("/app/parkinglot")
public class ParkingLotController extends CrudController<ParkingLot>{

	public ParkingLotController() {
		super(ParkingLot.class, "parkinglot");
	}
	
	@Override
	@GetMapping("/")
	public String form(Model model) {
		model.addAttribute("lots", crudService.getAll());
		return getViewPath("form");
	}
	
}
