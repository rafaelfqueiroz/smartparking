package com.smartparking.controllers.rest;

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

import com.smartparking.domain.ParkingLot;
import com.smartparking.enums.StateTypes;
import com.smartparking.notifiers.Notifier;
import com.smartparking.repositories.ParkingLotRepository;
import com.smartparking.vo.CarParkingVO;
import com.smartparking.vo.ParkingLotVO;

/**
 * @author Rafael Queiroz
 */
@RestController
@RequestMapping(value="/entrance")
public class EntranceController {
	
	private List<String> log = new ArrayList<String>();
	
	@Autowired
	private ParkingLotRepository parkingRepository;
	
	@Autowired
	private Notifier notifier;
	
	/**
	 * Notify a car has came to the parking. Returns the parking lot chosen and notify 
	 * any component of the IoT system about the parking lot.
	 * @param car
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value="/car")
	public ResponseEntity<ParkingLotVO> entrance(@RequestBody CarParkingVO car) throws Exception {
		log.add("Chegou: " + car.getTagValue() + " / " + new Date());
		ParkingLot lot = parkingRepository.findFirstByState(StateTypes.FREE.ordinal());
		if (lot == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		lot.setState(StateTypes.RESERVED.ordinal());
		parkingRepository.save(lot);
		notifier.notify(lot);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value="/logs")
	public ResponseEntity<List<String>> getLogs() {
		return new ResponseEntity<>(log, HttpStatus.OK);
	}
	
}
