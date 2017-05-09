package com.smartparking.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartparking.domain.ParkingLot;
import com.smartparking.repositories.ParkingLotRepository;
import com.smartparking.services.ParkingService;

@RestController
@RequestMapping(value="/parking")
public class ParkingLotController {

	@Autowired
	private ParkingService parking;
	
	@Autowired
	private ParkingLotRepository parkingRepository;
	
	@PostMapping(value="/occupy")
	public ResponseEntity<ParkingLot> occupy(@RequestBody ParkingLot parkingLot) {
		ParkingLot lot = parkingRepository.findByNumber(parkingLot.getNumber());
		if (lot == null) {
			return new ResponseEntity<>(lot, HttpStatus.NOT_FOUND);
		}
		
		lot.setState(parkingLot.getState());
		parkingRepository.save(lot);
		return new ResponseEntity<>(lot, HttpStatus.OK);
	}
	
	@GetMapping(value="/lots")
	public ResponseEntity<List<ParkingLot>> getAllParkingLot() {
		List<ParkingLot> lots = parkingRepository.findByState(false);
		return new ResponseEntity<>(lots, HttpStatus.OK);
	}
	
	@GetMapping(value="/pupulate")
	
	public ResponseEntity<List<ParkingLot>> populateParking() {
		parkingRepository.save(new ParkingLot(1, false));
		parkingRepository.save(new ParkingLot(2, false));
		parkingRepository.save(new ParkingLot(3, false));
		parkingRepository.save(new ParkingLot(4, false));
		parkingRepository.save(new ParkingLot(5, false));
		
		return getAllParkingLot();
	}
}
