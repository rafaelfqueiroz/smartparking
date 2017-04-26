package com.smartparking.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartparking.domain.ParkingLot;
import com.smartparking.services.ParkingService;

@RestController
@RequestMapping(value="/parking")
public class ParkingLotController {

	@Autowired
	private ParkingService parking;
	
	@PostMapping(value="/occupy")
	public boolean occupy(@RequestBody ParkingLot parkingLot) {
		return parking.occupyParkingLot(parkingLot);
	}
	
	@GetMapping(value="/lots")
	public List<ParkingLot> getAllParkingLot() {
		return parking.getParkingLots();
	}
}
