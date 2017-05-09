package com.smartparking.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartparking.domain.CarParking;
import com.smartparking.domain.ParkingLot;
import com.smartparking.notifiers.Notifier;
import com.smartparking.services.ParkingService;

/**
 * @author Rafael Queiroz
 */
@RestController
@RequestMapping(value="/entrance")
public class EntranceController {
	
	private List<String> log = new ArrayList<String>();
	
	@Autowired
	private ParkingService parking;
	
	@Autowired
	private Notifier notifier;
	
	@PostMapping(value="/car")
	public ResponseEntity<ParkingLot> entrance(@RequestBody CarParking car) throws Exception {
		log.add("Chegou: " + car.getTagValue() + " / " + new Date());
		ParkingLot lot = parking.getFreeParkingLot();
		if (lot == null) {
			return new ResponseEntity<>(lot, HttpStatus.NOT_FOUND);
		}
		notifier.notifyEntrance(lot);
		return new ResponseEntity<>(lot, HttpStatus.OK);
	}
	
	@GetMapping(value="/logs")
	public ResponseEntity<List<String>> getLogs() {
		return new ResponseEntity<>(log, HttpStatus.OK);
	}
	
}
