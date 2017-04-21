package com.smartparking.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartparking.ParkingService;
import com.smartparking.domain.CarParking;
import com.smartparking.domain.ParkingLot;
import com.smartparking.notifiers.Notifier;

/**
 * @author Rafael Queiroz
 */
@RestController
@RequestMapping(value="/entrance")
public class EntranceController {
	
	@Autowired
	private ParkingService parking;
	
	@Autowired
	private Notifier notifier;
	
	@PostMapping(value="/car")
	public ParkingLot entrance(@RequestBody CarParking car) {
		ParkingLot lot = parking.getFreeParkingLot();
		notifier.notifyEntrance(lot);
		return lot;
	}
	
}
