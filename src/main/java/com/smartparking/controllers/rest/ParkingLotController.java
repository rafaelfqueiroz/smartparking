package com.smartparking.controllers.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartparking.domain.ParkingLot;
import com.smartparking.enums.StateTypes;
import com.smartparking.repositories.ParkingLotRepository;
import com.smartparking.vo.ParkingLotVO;

@RestController
@RequestMapping(value="/parking")
public class ParkingLotController {

	@Autowired
	private ParkingLotRepository parkingRepository;
	
	
	@PostMapping(value="/occupy")
	public ResponseEntity<ParkingLotVO> changeParkingLotState(@RequestBody ParkingLot parkingLot) {
		ParkingLot lot = parkingRepository.findByNumber(parkingLot.getNumber());
		if (lot == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		lot.setState(parkingLot.getState());
		parkingRepository.save(lot);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value="/lots")
	public ResponseEntity<List<ParkingLotVO>> getAllParkingLot() {
		List<ParkingLot> lots = (List<ParkingLot>) parkingRepository.findAll();
		List<ParkingLotVO> lotsVO = lots.stream().map(pl -> ParkingLotVO.of(pl)).collect(Collectors.toList());
		return new ResponseEntity<>(lotsVO, HttpStatus.OK);
	}
	
	@GetMapping(value="/populate")
	public void populateParking() {
		parkingRepository.save(new ParkingLot(1, StateTypes.FREE.ordinal()));
		parkingRepository.save(new ParkingLot(2, StateTypes.FREE.ordinal()));
		parkingRepository.save(new ParkingLot(3, StateTypes.FREE.ordinal()));
		parkingRepository.save(new ParkingLot(4, StateTypes.FREE.ordinal()));
		parkingRepository.save(new ParkingLot(5, StateTypes.FREE.ordinal()));
	}
}
